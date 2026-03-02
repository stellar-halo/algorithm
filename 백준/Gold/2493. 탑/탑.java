import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N + 1];
        int[] receivers = new int[N + 1];
        int[] heights = new int[N + 1];
        int max;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            buildings[n] = Integer.parseInt(st.nextToken());
        }

        max = buildings[1];
        for (int n = 2; n <= N; n++) {
            int pre = n - 1;
            max = Math.max(max, buildings[pre]);

            if (buildings[pre] > buildings[n]) {
                receivers[n] = pre;
                heights[n] = buildings[pre];
            } else if (buildings[pre] == buildings[n]) {
                receivers[n] = receivers[pre];
                heights[n] = heights[pre];
            } else {
                if (max < buildings[n]) continue;
                while (pre > 0) {
                    if (heights[pre] > buildings[n]) {
                        receivers[n] = receivers[pre];
                        heights[n] = heights[pre];
                        break;
                    } else {
                        pre--;
                    }
                }
            }
        }

        for (int n = 1; n <= N; n++) {
            System.out.print(receivers[n] + " ");
        }
    }
}