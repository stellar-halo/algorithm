import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N];
        int[] distance = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N - 1; n++) {
            int d = Integer.parseInt(st.nextToken());
            distance[n] = d;
        }

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N ; n++) {
            int p = Integer.parseInt(st.nextToken());
            price[n] = p;
        }

        long min = Long.MAX_VALUE;
        long sum = 0;

        for (int n = 0; n < N - 1; n++) {
            if (price[n] < min) {
                min = price[n];
            }
            sum += min * distance[n];
        }

        System.out.println(sum);
    }
}

