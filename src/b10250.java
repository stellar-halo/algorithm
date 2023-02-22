import java.io.*;

public class b10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < t; idx++) {
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);

            int f = n % h;
            int r = (n / h) + 1;
            if(f == 0 ){
                f = h;
                r = n / h ;
            }

            if (r < 10) bw.write(f + "0" + r + "\n");
            else bw.write(f +""+ r + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
