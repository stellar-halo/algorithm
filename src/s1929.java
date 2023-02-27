import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class s1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

        for (int i = n; i <= m; i++) {
            numbers.add(i);
        }
        numbers.remove(1);

        for (int i = 2; i*i <= m; i++) {
            for (int idx = i*i; idx <= m; idx += i) numbers.remove(idx);
        }

        for(Integer i : numbers){
            bw.write(i+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
