import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            HashSet<Integer> note1 = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (note1.contains(num)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            System.out.print(sb);
        }
    }
}
