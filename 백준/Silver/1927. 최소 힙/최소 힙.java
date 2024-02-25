import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int temp = 0; temp < n; temp++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (minHeap.isEmpty()) bw.write(0 + "\n");
                else bw.write(minHeap.poll()+"\n");
            }
            else{
                minHeap.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
