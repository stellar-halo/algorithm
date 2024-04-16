import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] lagrange;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lagrange = new int[n + 1];

        dp();
        System.out.println(lagrange[n]);
    }

    static private void dp() {
        for (int idx = 1; idx <= n; idx++) {
            lagrange[idx] = Integer.MAX_VALUE;
            int maximum = (int) Math.sqrt(idx);
            for (int tmp = 1; tmp <= maximum; tmp++) {
                int square = tmp * tmp;
                lagrange[idx] = Math.min(lagrange[idx], lagrange[idx - square] + 1);
            }
        }
    }
}
