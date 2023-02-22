import java.io.*;
import java.util.Arrays;

public class b2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tmp = br.readLine().split(" ");
        String[] numbers = br.readLine().split(" ");
        int[] values = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(values);

        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int temp = 0;
        int answer = 0;

        for (int index = 0; index < n - 2; index++) {
            for (int idx = index + 1; idx < n - 1; idx++) {
                for (int i = idx + 1; i < n; i++) {
                    temp = values[index] + values[idx] + values[i];
                    if (temp > m) break;
                    else if (answer <= temp) answer = temp;
                }
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
