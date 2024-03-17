import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] numbers;
    static int[] operators = new int[4];
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int cnt, long res) {
        if (cnt == n) {
            max = Math.max(res, max);
            min = Math.min(res, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i] -= 1;
                switch (i) {
                    case 0:
                        dfs(cnt + 1, res + numbers[cnt]);
                        break;
                    case 1:
                        dfs(cnt + 1, res - numbers[cnt]);
                        break;
                    case 2:
                        dfs(cnt + 1, res * numbers[cnt]);
                        break;
                    case 3:
                        dfs(cnt + 1, res / numbers[cnt]);
                        break;
                }
                operators[i] += 1;
            }
        }
    }
}