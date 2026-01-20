import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] grapeJuices;
    static int[] dp;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grapeJuices = new int[N + 1];
        dp = new int[N + 1];
        for (int n = 0; n < N; n++) {
            int grapeJuice = Integer.parseInt(br.readLine());
            grapeJuices[n + 1] = grapeJuice;
        }
        loop(1);
        System.out.println(dp[N]);
    }

    public static void loop(int n) {
        if (n == 1) {
            dp[1] = grapeJuices[1];
        }
        else if (n == 2) {
            dp[2] = grapeJuices[1] + grapeJuices[2];
        }
        else{

            dp[n] = Math.max(
                    dp[n - 1],
                    Math.max(
                            dp[n - 2] + grapeJuices[n],
                            dp[n - 3] + grapeJuices[n - 1] + grapeJuices[n]
                    )
            );
        }

        if (n < N) loop(n + 1);
    }

}
