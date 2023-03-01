import java.io.*;

public class b2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        String origin = n;
        int f = n.length();
        int nn = Math.max(Integer.parseInt(n) - f * 9, 0);
        int sum = 0;
        int m = 0;
        for (int i = 0; i <= f * 9; i++) {
            sum = 0;
            nn++;
            n = Integer.toString(nn);
            for (int idx = 0; idx < n.length(); idx++) {
                sum += n.charAt(idx) - '0';
            }
            if (Integer.parseInt(origin) == sum + nn) {
                if (m == 0) m = nn;
                else {
                    m = Math.min(m, nn);
                }
            }
        }
        bw.write("" + m);
        br.close();
        bw.flush();
        bw.close();
    }
}
