package s1018;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] checkerBoard = new String[n];
        int tmp;
        int answer = 64;

        for (int i = 0; i < n; i++) {
            checkerBoard[i] = br.readLine();
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int idx = 0; idx <= m - 8; idx++) {
                tmp = 0;
                for (int tmpN = 0; tmpN < 8; tmpN++) {
                    for (int tmpM = 0; tmpM < 8; tmpM++) {
                        char c = checkerBoard[i + tmpN].charAt(idx + tmpM);
                        if (tmpN % 2 == 1 && tmpM % 2 == 1 && c == 'W') tmp++;
                        if (tmpN % 2 == 1 && tmpM % 2 == 0 && c == 'B') tmp++;
                        if (tmpN % 2 == 0 && tmpM % 2 == 1 && c == 'B') tmp++;
                        if (tmpN % 2 == 0 && tmpM % 2 == 0 && c == 'W') tmp++;
                    }
                }
                tmp = Math.min(tmp, 64 - tmp);
                answer = Math.min(answer, tmp);
            }
        }
        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
