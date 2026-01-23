import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] dp;
    static String[][] stickers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int n = 0; n < T; n++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N + 1][3];
            stickers = new String[2][N];
            stickers[0] = br.readLine().split(" ");
            stickers[1] = br.readLine().split(" ");

            removeStickers(1);

            int ans = Math.max(
                    Math.max(dp[N][2], dp[N][1]),
                    dp[N][0]);
            System.out.println(ans);
        }

    }

    public static void removeStickers(int n) {
        if (n == N + 1) return;

        if (n == 1) {
            dp[n][0] = Integer.parseInt(stickers[0][0]);
            dp[n][1] = Integer.parseInt(stickers[1][0]);
            dp[n][2] = 0;
        } else {
            dp[n][0] = Math.max(dp[n - 1][2], dp[n - 1][1]) + Integer.parseInt(stickers[0][n - 1]);
            dp[n][1] = Math.max(dp[n - 1][2], dp[n - 1][0]) + Integer.parseInt(stickers[1][n - 1]);
            dp[n][2] = Math.max(
                    Math.max(dp[n - 1][2], dp[n - 1][1]),
                    dp[n - 1][0]);
        }

        removeStickers(n + 1);
    }

}
