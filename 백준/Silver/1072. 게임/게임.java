import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = (Y * 100) / X;

        // 승률이 99 이상이면 절대 변하지 않음
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        int left = 1;
        int right = 1000000000;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            long newZ = (Y + mid) * 100 / (X + mid);

            if (newZ > Z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
