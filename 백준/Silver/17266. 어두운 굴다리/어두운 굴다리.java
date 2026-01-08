import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] lamps = new int[M];
        String[] temps = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            lamps[i] = Integer.parseInt(temps[i]);
        }
        int max = Math.max(lamps[0], N - lamps[M - 1]);

        for (int i = 0; i < M - 1; i++) {
            int min = Math.round((float) (lamps[i + 1] - lamps[i]) / 2);
            max = Math.max(min, max);
        }

        System.out.println(max);
    }
}
