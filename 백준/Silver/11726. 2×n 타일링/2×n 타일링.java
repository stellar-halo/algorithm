import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int idx = 3; idx <= n; idx++) {
            dp[idx] = (dp[idx - 1] + dp[idx - 2])%10007;
        }
        System.out.println(dp[n]);
    }
}