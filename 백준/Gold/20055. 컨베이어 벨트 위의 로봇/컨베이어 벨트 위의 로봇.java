import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static private int n, k, cycle, len, putDown, pickUp;
    static private int[] durability;
    static private boolean[] isRobot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cycle = 0;
        len = n * 2;
        durability = new int[len];
        isRobot = new boolean[len];
        st = new StringTokenizer(br.readLine());

        for (int temp = 0; temp < len; temp++) {
            durability[temp] = Integer.parseInt(st.nextToken());
        }
        //초기 입력 완

        /*필요한 정보
        1. 컨베이어 벨트의 내구도 belt
        2. 컨베이어 칸에 로봇이 있는지 isRobot
        3. 내리는 위치인지, 올리는 위치인지
        4. 내구도가 0인 컨베이어 벨트의 개수 확인 k
         */

        /* 로직
        1. cycle 증가
        2. 벨트 회전 (pickUp, putDown 인덱스 증가)
        3. isRobot을 검사해서 앞에 로봇이 없으면 한 칸 전진시키면서 내구도 감소
        4. 매번 로봇을 올리고, 내구도 감소 시키면서 k 감소시켜야 하는지 체크
        ** k가 0이 되면 while문을 빠져나온다.
         */
        pickUp = 0;
        putDown = n - 1;
        while (true) {
            cycle++;
            // 1. 컨베이어 벨트와 로봇을 회전시킴
            rotateBelt();
            // 2. 로봇 이동
            moveRobots();
            // 3. pickUp 위치에 로봇을 올림
            putRobot();
            // 4. 내구도가 0인 칸의 개수를 체크함
            if (countZeroDurability() >= k) break;
        }
        System.out.println(cycle);
    }

    static private void rotateBelt() {
        int lastDurability = durability[len - 1];
        for (int i = len - 1; i > 0; i--) {
            durability[i] = durability[i - 1];
        }
        durability[0] = lastDurability;

        boolean lastRobot = isRobot[len - 1];
        for (int i = len - 1; i > 0; i--) {
            isRobot[i] = isRobot[i - 1];
        }
        isRobot[0] = lastRobot;

        // 로봇이 내리는 위치에 도착하면 로봇을 내림
        if (isRobot[putDown]) {
            isRobot[putDown] = false;
        }
    }

    private static void moveRobots() {
        for (int i = putDown - 1; i != pickUp; i = (i - 1 + len) % len) {
            int next = (i + 1) % len;
            //로봇이 있고, 다음에 로봇이 없으며 내구도가 0보다 높다면 이동
            if (isRobot[i] && !isRobot[next] && durability[next] > 0) {
                isRobot[i] = false;
                isRobot[next] = true;
                durability[next]--;
            }
        }

        // 로봇이 내리는 위치에 도착하면 로봇을 내림
        if (isRobot[putDown]) {
            isRobot[putDown] = false;
        }
    }

    private static void putRobot() {
        //내구성이 0보다 높고, 로봇이 없다면 로봇을 놓는다
        if (durability[pickUp] > 0 && !isRobot[pickUp]) {
            isRobot[pickUp] = true;
            durability[pickUp]--;
        }
    }

    private static int countZeroDurability() {
        int count = 0;
        for (int durability : durability) {
            if (durability == 0) {
                count++;
            }
        }
        return count;
    }
}
