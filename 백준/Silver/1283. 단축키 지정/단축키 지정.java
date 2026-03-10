import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] shortcut = new int[26];
        StringBuilder sb = new StringBuilder();
        boolean isShortCut;

        for (int n = 0; n < N; n++) {
            String word = br.readLine();
            isShortCut = false;
            String[] words = word.split(" ");

            for (int idx = 0; idx < words.length; idx++) {
                int f = words[idx].toUpperCase().charAt(0);
                StringBuilder tempSb = new StringBuilder(words[idx].substring(1));
                if (shortcut[f - 65] == 0 && !isShortCut) {
                    shortcut[f - 65] = 1;
                    words[idx] = "[" + words[idx].charAt(0) + "]" + tempSb;

                    for (String s : words) {
                        sb.append(s).append(" ");
                    }
                    sb.append("\n");
                    isShortCut = true;
                }
            }

            if (!isShortCut) {
                for (int idx = 0; idx < word.length(); idx++) {
                    int num = word.toUpperCase().charAt(idx) - 65;
                    char c = word.charAt(idx);
                    if (num < 0) {
                        sb.append(c);
                        continue;
                    }
                    if (shortcut[num] == 0 && !isShortCut) {
                        shortcut[num] = 1;
                        isShortCut = true;
                        sb.append("[").append(c).append("]");
                    } else {
                        sb.append(c);
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}