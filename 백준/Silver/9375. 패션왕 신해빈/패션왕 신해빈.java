import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> closet = new HashMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 이름은 필요 없음
                String type = st.nextToken();

                closet.put(type, closet.getOrDefault(type, 0) + 1);
            }

            int ans = 1;

            for (int count : closet.values()) {
                ans *= (count + 1);
            }

            System.out.println(ans - 1);
        }
    }
}
