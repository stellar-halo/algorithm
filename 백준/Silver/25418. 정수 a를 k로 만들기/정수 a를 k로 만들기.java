import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int K = scanner.nextInt();

        int[] dp = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[A] = 0;

        for (int i = A; i <= K; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            if (i + 1 <= K) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }

            if (2 * i <= K) {
                dp[2 * i] = Math.min(dp[2 * i], dp[i] + 1);
            }
        }

        System.out.println(dp[K]);
    }
}
