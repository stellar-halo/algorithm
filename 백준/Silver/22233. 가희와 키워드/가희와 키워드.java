import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for (int n = 0; n < N; n++) {
            set.add(br.readLine());
        }

        for (int m = 0; m < M; m++) {
            String[] words = br.readLine().split(",");

            for (String w : words) {
                set.remove(w);
            }

            System.out.println(set.size());
        }
    }
}