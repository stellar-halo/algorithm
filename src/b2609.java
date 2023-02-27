import java.io.*;

public class b2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (m % i == 0) max = i;

                if (m % (n / i) == 0) {
                    max = n / i;
                    break;
                }
            }
        }

        bw.write(max + "\n");
        bw.write((n / max * m / max * max) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
