import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sentence = br.readLine().split("");
        int len = sentence.length;
        int[][] alphabetCount = new int[len][26];
        for (int temp = 0; temp < len; temp++) {
            char currentChar = sentence[temp].charAt(0); // 문자열을 char로 변환
            int idx = (int) currentChar - 97; // 아스키 코드로 변환 후 인덱스 계산
            if (temp == 0) {
                alphabetCount[temp][idx] = 1;
            } else {
                for (int tmp = 0; tmp < 26; tmp++) {
                    if (tmp == idx) alphabetCount[temp][idx] = alphabetCount[temp - 1][idx] + 1;
                    else alphabetCount[temp][tmp] = alphabetCount[temp - 1][tmp];
                }
            }
        }
        int q = Integer.parseInt(br.readLine());
        for (int temp = 0; temp < q; temp++) {
            String[] inputs = br.readLine().split(" ");
            char currentChar = inputs[0].charAt(0);
            int alphabet = (int) currentChar - 97;
            int l = Integer.parseInt(inputs[1]);
            int r = Integer.parseInt(inputs[2]);
            int ans;
            if (l == 0) {
                ans = alphabetCount[r][alphabet];
            } else {
                ans = alphabetCount[r][alphabet] - alphabetCount[l - 1][alphabet];
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
