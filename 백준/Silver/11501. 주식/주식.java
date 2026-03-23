import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            T--;
            int N = Integer.parseInt(br.readLine());
            int[] stocks = new int[N];
            int highest = 0;
            long maximumProfit = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int n = 0; n < N; n++) {
                stocks[n] = Integer.parseInt(st.nextToken());
            }

            for (int today = N - 1; today >= 0; today--) {
                if (highest < stocks[today]) {
                    highest = stocks[today];
                }else{
                    maximumProfit += highest - stocks[today];
                }
            }
            System.out.println(maximumProfit);
        }
    }
}

