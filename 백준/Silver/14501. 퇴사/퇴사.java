import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] fee;
    private static int[] days;
    private static int[] maximumProfit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        fee = new int[n];
        days = new int[n];
        maximumProfit = new int[n + 1];

        for (int idx = 0; idx < n; idx++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            days[idx] = d;
            fee[idx] = f;
        }

        int maximum = 0;

        for (int idx = 0; idx < n; idx++) {
            // 현재까지의 최대 수익 갱신
            maximumProfit[idx + 1] = Math.max(maximumProfit[idx + 1], maximumProfit[idx]);

            int nextIdx = idx + days[idx];

            if (nextIdx <= n) {
                maximumProfit[nextIdx] = Math.max(maximumProfit[nextIdx], maximumProfit[idx] + fee[idx]);
                maximum = Math.max(maximum, maximumProfit[nextIdx]);
            }
        }

        System.out.println(maximum);
    }
}
