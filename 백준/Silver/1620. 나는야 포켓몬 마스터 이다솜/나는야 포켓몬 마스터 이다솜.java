import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] pocketmons = new String[N + 1];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            pocketmons[i] = name;
            map.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            char c = q.charAt(0);

            if (Character.isDigit(c)) {
                sb.append(pocketmons[Integer.parseInt(q)]).append('\n');
            } else {
                sb.append(map.get(q)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
