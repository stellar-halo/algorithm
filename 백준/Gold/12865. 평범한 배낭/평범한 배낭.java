import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, k, maximumHappiness;
    static List<Thing> things;
    static int[][] dp;

    static private class Thing {
        int w, v;

        public Thing(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력값 입력
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        maximumHappiness = 0;
        things = new ArrayList<>();
        dp = new int[k + 1][n + 1];
        things.add(new Thing(0, 0));
        for (int tmp = 0; tmp < n; tmp++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            things.add(new Thing(w, v));
        }
        dp();
        System.out.println(maximumHappiness);
    }

    private static void dp() {
        //row는 가방의 무게
        //col은 각 하나의 물건들
        for (int row = 0; row < k + 1; row++) {
            for (int col = 0; col < n + 1; col++) {
                //0kg이거나 아이템이 0번일 때에는 아무것도 못 넣으므로 0로 초기화
                if (row == 0 || col == 0) dp[row][col] = 0;
                else {
                    if (row >= things.get(col).w) {
                        //이번 물건을 넣기 전에 가방 가치와, 이번 물건을 넣기 위해 필요한 만큼의 무게로 돌아간 가방의 가치 + 이번 물건의 가치 중에서 더 큰 값을 dp에 저장
                        //필요한 만큼의 무게로 돌아갔을 때, -1의 상태가 가장 최선의 무게임을 알 수 있는 이유는, 하나씩 비교해주면서 가장 최선의 상태로 업데이트 해주기 때문이다.
                        dp[row][col] = Math.max(dp[row - things.get(col).w][col - 1] + things.get(col).v, dp[row][col - 1]);
                    } else dp[row][col] = dp[row][col - 1];
                }
                //가장 최선의 값을 가진 것으로 갱신
                maximumHappiness = Math.max(maximumHappiness, dp[row][col]);
            }
        }
    }
}
