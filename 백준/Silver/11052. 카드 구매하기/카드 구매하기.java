import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, maximumTotalCost;
    static int[] packCostList, dp;

    public static void main(String[] args) throws IOException {
        //초기값 입력
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maximumTotalCost = 0;
        st = new StringTokenizer(br.readLine());
        packCostList = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            packCostList[i + 1] = Integer.parseInt(st.nextToken());
        }

        // dp문제
        // dp[k] = Math.max(dp[k-1] + 1, dp[k-2]+2, dp[k-3]+3 , ,,,) 매 수마다 이런 식으로 카드 개의 개수만큼 비교해 맥스를 뽑아내자.
        // n이 1000이기 때문에 n^2 노프라블럼
        // 금액의 최댓값을 int가 될까? 10000*1000 = 10,000,000 -> 충분히 가능
        dp();
        maximumTotalCost = dp[n];
        System.out.println(maximumTotalCost);
    }

    private static void dp() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < j) break;
                //기존의 값과 j만큼의 무게를 뺀 최선의 값+j무게 카드의 가중치 중 더 큰값으로 갱신
                dp[i] = Math.max(dp[i], dp[i - j] + packCostList[j]);
            }
        }
    }
}
