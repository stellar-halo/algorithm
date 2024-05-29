import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static private int n, m, count, answer;
    static private int[] waitingList, friendWaitingIdx;
    static private ArrayList<Integer> friendWaitingList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //초기 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = 0;
        answer = m;
        waitingList = new int[n];
        friendWaitingList = new ArrayList<>();
        friendWaitingIdx = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            waitingList[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            friendWaitingList.add(num);
        }

        /* waitingList를 앞에 인덱스부터 탐색하면서, 친구가 대기 명단의 어디에 위치해있는지 찾는다.
        친구의 대기 명단 숫자가 친구 수보다 같거나 적은 곳에 위치하고 있는 수를 찾고
        전체 친구 수에서 그만큼을 뺀다. */

        for (int i = 0; i < n; i++) {
            //이번 대기자
            int person = waitingList[i];
            //이번 대기자가 친구인가?
            boolean isFriend = friendWaitingList.contains(person);
            //친구라면, 인덱스에 추가하고 count 증가
            if (isFriend) {
                friendWaitingIdx[count] = i;
                count++;
            }
            //친구를 다 찾았다면 for문에서 나온다.
            if (count == m) {
                break;
            }
        }

        //친구들의 대기 순번을 돌면서 m 보다 작으면 바꿀 필요가 없기 때문에 -1
        for (int i = 0; i < m; i++) {
            int idx = friendWaitingIdx[i];
            if (idx < m) {
                answer--;
            }
        }

        System.out.println(answer);
    }
}
