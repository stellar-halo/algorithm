import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] balls = br.readLine().split("");

        int leftR = 0;
        int leftB = 0;
        int rightR = 0;
        int rightB = 0;

        boolean isStart = false;
        for (int i = 0; i < N; i++) {
            if (!isStart && balls[i].equals("B")) isStart = true;
            if (balls[i].equals("R") && isStart) leftR++;
        }

        isStart = false;
        for (int i = 0; i < N; i++) {
            if (!isStart && balls[i].equals("R")) isStart = true;
            if (balls[i].equals("B") && isStart) leftB++;
        }

        isStart = false;
        for (int i = N - 1; i >= 0; i--) {
            if (!isStart && balls[i].equals("R")) isStart = true;
            if (balls[i].equals("B") && isStart) rightR++;
        }

        isStart = false;
        for (int i = N - 1; i >= 0; i--) {
            if (!isStart && balls[i].equals("B")) isStart = true;
            if (balls[i].equals("R") && isStart) rightB++;
        }

        int min = Math.min(leftR, Math.min(leftB, Math.min(rightR, rightB)));

        System.out.println(min);
    }
}

