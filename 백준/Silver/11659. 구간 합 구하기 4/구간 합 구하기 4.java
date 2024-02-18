import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] numbers = br.readLine().split(" ");
        long[] sum = new long[n];
        long prev = 0;

        for (int temp = 0; temp < n; temp++) {
            sum[temp] = prev + Integer.parseInt(numbers[temp]);
            prev = sum[temp];
        }

        for (int temp = 0; temp < m; temp++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            long answer = 0;
            end--;
            start--;
            if (start == 0) {
                answer = sum[end];
            } else {
                answer = sum[end] - sum[start - 1];
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
