import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitors = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            visitors[n] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 0; i < X; i++) {
            max += visitors[i];
        }
        int temp = max;
        int series = 1;
        for (int date = X; date < N; date++) {
            temp -= visitors[date - X];
            temp += visitors[date];

            if (temp == max) {
                series++;
            } else if (temp > max) {
                max = temp;
                series = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(series);
        }
    }
}
