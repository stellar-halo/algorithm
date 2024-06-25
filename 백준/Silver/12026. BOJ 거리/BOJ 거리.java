import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static String[] blockList;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        blockList = new String[n];
        dp = new int[n];
        dp[0] = 0;
        blockList = br.readLine().split("");

        for (int i = 1; i < n; i++) {
            if (blockList[i].equals("B")) {
                findMin("J", i);
            } else if (blockList[i].equals("O")) {
                findMin("B", i);
            } else {
                findMin("O", i);
            }
        }

        System.out.println(dp[n - 1]);
    }

    private static void findMin(String s, int idx) {
        for (int i = idx - 1; i >= 0; i--) {
            if (blockList[i].equals(s)) {
                if (dp[i] == -1) {
                    if(dp[idx] == 0) dp[idx] = -1;
                } else {
                    int gap = idx - i;
                    if (dp[idx] == 0 || dp[idx] == -1) dp[idx] = dp[i] + (gap * gap);
                    else {
                        dp[idx] = Math.min(dp[idx], dp[i] + (gap * gap));
                    }
                }
            }
        }
        if (dp[idx] == 0) dp[idx] = -1;
    }
}
