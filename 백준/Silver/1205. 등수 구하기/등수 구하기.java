import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int ans = 0;
        int same = 0;
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int n = 0; n < N; n++) {
            int score = Integer.parseInt(st.nextToken());

            if (score > newScore) {
                ans++;
            } else if (score == newScore) {
                ans++;
                same++;
            }
        }


        ans++;

        if (ans <= P) {
            ans -= same;
            System.out.println(ans);
        } else {
            System.out.println("-1");
        }
    }
}