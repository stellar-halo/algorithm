import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        boolean[] isDecimal = new boolean[10001];
        Arrays.fill(isDecimal, true);
        isDecimal[0] = isDecimal[1] = false;

        for (int n = 2; n <= 10000; n++) {
            for (int d = 2; d < n; d++) {
                if (n % d == 0) {
                    isDecimal[n] = false;
                    break;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int a = 0;
            int b = 0;
            int mid = N / 2;
            int leftOver = N - mid;

            while (!isDecimal[mid] || !isDecimal[leftOver]) {
                mid--;
                leftOver++;
            }
            a = mid;
            b = leftOver;

            System.out.println(a + " " + b);
        }
    }
}