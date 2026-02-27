import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine().toUpperCase();
        int[] characters = new int[27];

        for (int idx = 0; idx < sentence.length(); idx++) {
            characters[sentence.charAt(idx)-65]++;
        }

        char ans = '?';
        int max = 0;

        for (int idx = 0; idx < 27; idx++) {
            if (characters[idx] > max) {
                ans = (char) (idx+65);
                max = characters[idx];
            } else if (characters[idx] == max) {
                ans = '?';
            }
        }

        System.out.println(ans);
    }
}