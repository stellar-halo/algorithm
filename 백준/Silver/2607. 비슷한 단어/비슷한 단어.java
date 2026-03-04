import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String standard = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] counts = new int[26];
        int ans = 0;

        for (int idx = 0; idx < standard.length(); idx++) {
            char c = standard.charAt(idx);
            counts[c - 65]++;
        }

        for (int n = 1; n < N; n++) {
            String word = br.readLine();
            int[] alphabets = new int[26];

            for (int idx = 0; idx < word.length(); idx++) {
                char c = word.charAt(idx);
                alphabets[c - 65]++;
            }

            int s = standard.length();
            int w = word.length();

            for (int idx = 0; idx < 26; idx++) {
                int min = Math.min(counts[idx], alphabets[idx]);
                s -= min;
                w -= min;
            }

            if (s < 2 && w < 2) {
                ans++;
            }
        }

        sb.append(ans);
        System.out.println(sb);
    }
}