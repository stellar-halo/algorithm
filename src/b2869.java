import java.io.*;

public class b2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] i = br.readLine().split(" ");

        int a = Integer.parseInt(i[0]);
        int b = Integer.parseInt(i[1]);
        int v = Integer.parseInt(i[2]);
        int day = 0;

        day = (v-a) / (a-b) ;
        if((v-a) % (a-b) == 0) day++;
        else day += 2;

        bw.write(day+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
