import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[][] botList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        botList = new int[n][2];
        for (int tmp = 0; tmp < n; tmp++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            botList[tmp][0] = Integer.parseInt(st.nextToken());
            botList[tmp][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] bot : botList) {
            //첫번째의 경우는 무조건 더해주기
            if (answer == 0) answer = bot[1] + 1;
                //그 이후에는 비활성화 시간에 나타나면 통과하고, 활성화 시간이라면 기다리기
            else {
                int disabledTime = bot[0];
                int activateTime = bot[1];
                //활성화 시간보다 짧은 경우
                if (answer < activateTime) answer = activateTime + 1;
                    // 첫 번째 주기에 비활성화 시기에 걸린 경우
                else if (answer < disabledTime + activateTime) answer = answer + 1;
                    // 그 이후라면
                else {
                    // 주기 이후 남은 시간을 구하고
                    int remain = answer % (disabledTime + activateTime);
                    // 활성화 시간 중이라면 활성화만큼 기다리고 + 1
                    if (remain < activateTime) answer = answer - remain + activateTime + 1;
                    // 비활성화 시간 중이라면 출발
                    else answer = answer + 1;
                }
            }
        }

        System.out.println(answer);
    }
}
