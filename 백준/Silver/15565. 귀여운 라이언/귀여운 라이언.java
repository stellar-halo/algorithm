import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dolls = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우
        int left = 0, right = 0, count = 0, minLength = Integer.MAX_VALUE;

        while (right < n) {
            if (dolls[right] == 1) {
                count++;
            }

            while (count >= k) {
                minLength = Math.min(minLength, right - left + 1);
                if (dolls[left] == 1) {
                    count--;
                }
                left++;
            }
            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minLength);
        }
    }
}
