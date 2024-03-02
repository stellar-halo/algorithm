import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] sentence = br.readLine().toCharArray();
        int len = sentence.length;
        int[][] alphabetCount = new int[len][26];
        for (int temp = 0; temp < len; temp++) {
            char currentChar = sentence[temp];
            int idx = (int) currentChar - 'a';

            if (temp > 0) {
                System.arraycopy(alphabetCount[temp - 1], 0, alphabetCount[temp], 0, 26);
            }

            alphabetCount[temp][idx]++;
        }
        int q = Integer.parseInt(br.readLine());
        for (int temp = 0; temp < q; temp++) {
            String[] inputs = br.readLine().split(" ");
            char currentChar = inputs[0].charAt(0);
            int alphabet = (int) currentChar - 'a';
            int l = Integer.parseInt(inputs[1]);
            int r = Integer.parseInt(inputs[2]);

            int ans = (l == 0) ? alphabetCount[r][alphabet] : alphabetCount[r][alphabet] - alphabetCount[l - 1][alphabet];

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
