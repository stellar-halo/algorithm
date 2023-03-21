package b11050;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] i = br.readLine().split(" ");
        int n = Integer.parseInt(i[0]);
        int k = Integer.parseInt(i[1]);
        int result;

        result = factorial(n) / (factorial(n - k) * factorial(k));

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int factorial(int f) {
        if (f == 1 || f == 0) return 1;
        else {
            return f * factorial(f - 1);
        }
    }
}
