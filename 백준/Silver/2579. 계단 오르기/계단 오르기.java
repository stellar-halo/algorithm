import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int idx = 1; idx <= n; idx++) {
            stairs[idx] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[i] = stairs[1];
            else if (i == 2) dp[i] = stairs[2] + stairs[1];
            else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
            }
        }

        System.out.println(dp[n]);
    }
}
