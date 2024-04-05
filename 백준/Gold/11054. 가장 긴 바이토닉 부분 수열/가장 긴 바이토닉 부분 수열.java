import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[] a;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        //입력값 지정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 1;
        a = new int[n];
        dp = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int tmp = 0; tmp < n; tmp++) {
            a[tmp] = Integer.parseInt(st.nextToken());
        }

        dp();

        System.out.println(answer);
    }

    //언제가 최고점으로 할 것인가 그게 관건이다.
    //그럼 매 수에서 최고일 경우 vs 증가일 경우를 판단하면 되나
    //수열의 길이는 1000이므로 n^2도 될 것 같다.
    //그럼 왼쪽에서 오른쪽으로 갈 때, 각 위치에서 몇 번째 오름차순인지 LIS
    //오른쪽에서 왼쪽으로 갈 때, 각 위치에서 몇 번째 내림차순인지 저장하자. LDS
    private static void dp() {

        //LIS (앞에서 이동)
        for (int tmp = 0; tmp < n; tmp++) {
            dp[tmp][0] = 1;
            int prev = tmp - 1;
            //0에 도달하면 다 검사한 것
            while (prev >= 0) {
                if (a[prev] < a[tmp]) {
                    //작다면 비교해서 더 큰 값을 넣어주자.
                    dp[tmp][0] = Math.max(dp[prev][0] + 1, dp[tmp][0]);
                }
                //비교 위치를 옮겨줌
                prev = prev - 1;
            }
        }

        //LDS (뒤에서 거꾸로 이동, 그래서 로직은 동일)
        for (int tmp = n - 1; tmp >= 0; tmp--) {
            dp[tmp][1] = 1;
            int prev = tmp + 1;
            //n이면 끝까지 다 검사한 것
            while (prev < n) {
                if (a[prev] < a[tmp]) {
                    //작다면 비교해서 더 큰 값을 넣어주자.
                    dp[tmp][1] = Math.max(dp[prev][1] + 1, dp[tmp][1]);
                }
                //비교 위치를 옮겨줌
                prev = prev + 1;
            }
        }

        for (int idx = 0; idx < n; idx++) {
            answer = Math.max(answer, dp[idx][0] + dp[idx][1] - 1);
        }
    }
}
