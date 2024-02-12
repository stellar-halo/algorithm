import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int temp = 0; temp < testCase; temp++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int distance = end - start;
            long sum = 0;
            long preSum;
            int shortest = 0;

            for (int k = 1; k < Integer.MAX_VALUE; k++) {
                preSum = sum;
                sum += 2L * k;
                if (preSum < distance && distance <= sum) { //k가 구해짐
                    long diff = distance - preSum;
                    if (diff <= k) {
                        shortest = 2 * k - 1;
                    } else shortest = 2 * k;
                    break;
                }
            }
            bw.write(shortest + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
