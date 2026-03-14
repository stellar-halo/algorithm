import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> dic = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                dic.put(word, dic.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(dic.keySet());

        words.sort((a, b) -> {
            // 1. 빈도수 내림차순
            if (!dic.get(a).equals(dic.get(b))) {
                return dic.get(b) - dic.get(a);
            }

            // 2. 길이 내림차순
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }

            // 3. 사전순 오름차순
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }

        System.out.print(sb);
    }
}