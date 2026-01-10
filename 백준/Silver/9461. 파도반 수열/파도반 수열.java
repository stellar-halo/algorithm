import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] pados = new long[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            System.out.println(pado(Long.parseLong(br.readLine()) - 1));
        }
    }

    public static long pado(long n) {
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        } else {
            if (pados[Math.toIntExact(n - 2)] == 0) {
                pados[Math.toIntExact(n - 2)] = pado(n - 2);
            }
            if (pados[Math.toIntExact(n - 3)] == 0) {
                pados[Math.toIntExact(n - 3)] = pado(n - 3);
            }
        }
        return pados[Math.toIntExact(n - 2)] + pados[Math.toIntExact(n - 3)];
    }
}
