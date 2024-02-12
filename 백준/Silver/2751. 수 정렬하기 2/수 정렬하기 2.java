import java.io.*;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int idx = 0;idx<n;idx++){
            int tmp = Integer.parseInt(br.readLine());
            treeSet.add(tmp);
        }
        
        for(int idx = 0;idx<n;idx++){
            Integer tmp = treeSet.first();
            bw.write(tmp+"\n");
            treeSet.remove(tmp);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
