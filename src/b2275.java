import java.io.*;

public class b2275 {
    public static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sum = 0;
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            resident(k, n);
            bw.write(sum + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void resident(int k, int n) {
        if (k == 0) {
            sum += n;
        } else {
            for (int i = 1; i <= n; i++) {
                resident(k - 1, i);
            }
        }
    }
}
