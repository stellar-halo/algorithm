import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] alphabets;

        while (T > 0) {
            T--;
            alphabets = new ArrayList[26];

            for (int i = 0; i < 26; i++) {
                alphabets[i] = new ArrayList<>();
            }

            String line = br.readLine();

            for (int idx = 0; idx < line.length(); idx++) {
                int c = line.charAt(idx) - 'a';
                alphabets[c].add(idx);
            }

            int k = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < 26; i++) {
                if (alphabets[i].size() >= k) {
                    for (int start = 0; start <= alphabets[i].size() - k; start++) {
                        int end = start + k - 1;

                        int diff = alphabets[i].get(end) - alphabets[i].get(start) + 1;
                        min = Math.min(diff, min);
                        max = Math.max(diff, max);
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}