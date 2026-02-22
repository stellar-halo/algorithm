import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> decimals = new ArrayList<>();

        for (int n = 2; n <= 100000; n++) {
            boolean isDecimal = true;
            for (int d = 2; d < n; d++) {
                if (n % d == 0) {
                    isDecimal = false;
                    break;
                }
            }

            if (isDecimal) decimals.add(n);
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int a = 0;
            int b = 0;
            int mid = N / 2;
            int leftOver = N - mid;

            while (!decimals.contains(mid) || !decimals.contains(leftOver)) {
                mid--;
                leftOver++;
            }
            a = mid;
            b = leftOver;

            System.out.println(a + " " + b);
        }
    }
}