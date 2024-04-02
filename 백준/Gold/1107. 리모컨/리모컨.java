import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] brokenButtons;

    public static void main(String[] args) throws IOException {
        // 입력값 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        brokenButtons = new boolean[10];
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int temp = 0; temp < m; temp++) {
                int brokenButton = Integer.parseInt(st.nextToken());
                brokenButtons[brokenButton] = true;
            }
        }
        //그냥 버튼 위아래 눌러서 이동하는 경우
        int forceCount = Math.abs(n - 100);

        int closerNumCount = getClosestNumber();

        //둘 중 더 작은 값으로
        int answer = Math.min(forceCount, closerNumCount);
        System.out.println(answer);
    }

    private static int getClosestNumber() {
        int minDiff = Integer.MAX_VALUE;
        int closestNumber = n;

        for(int tmp=0;tmp<=1000000;tmp++){
            String tmpStr = String.valueOf(tmp);
            boolean isPossible = true;

                for (int j = 0; j < tmpStr.length(); j++) {
                    if (brokenButtons[tmpStr.charAt(j) - '0']) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    int diff = Math.abs(tmp - n) + tmpStr.length();
                    if (diff < minDiff) {
                        minDiff = diff;
                    }
                }
            }

        return minDiff;
    }
}
