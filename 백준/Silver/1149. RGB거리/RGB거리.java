import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dp;
    static int[][] houses;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        houses = new int[N][3];
        dp = new int[N][3];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            houses[n][0] = Integer.parseInt(st.nextToken());
            houses[n][1] = Integer.parseInt(st.nextToken());
            houses[n][2] = Integer.parseInt(st.nextToken());
        }
        paintHouse(1);

        int ans = dp[N - 1][0];
        for (int d : dp[N - 1]) {
            ans = Math.min(d, ans);
        }

        System.out.println(ans);
    }

    public static void paintHouse(int n) {
        PriorityQueue<Integer> pq;

        if (n == 1) {
            dp[0] = houses[0];
        } else {
            for (int idx = 0; idx < 3; idx++) {
                pq = new PriorityQueue<>();

                int next = (idx + 1) % 3;
                int prev = (idx + 2) % 3;
                pq.add(dp[n - 2][next] + houses[n - 1][idx]);
                pq.add(dp[n - 2][prev] + houses[n - 1][idx]);

                if (!pq.isEmpty()) dp[n - 1][idx] = pq.peek();
            }
        }

        if(n != N) paintHouse(n + 1);
    }

}
