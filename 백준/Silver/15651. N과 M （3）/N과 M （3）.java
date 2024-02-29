import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        answer = new int[m];
        for (int temp = 1; temp <= n; temp++) {
            answer[0] = temp;
            backTracking(temp, 1);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int node, int length) throws IOException {
        if (length == m) {
            for (int s : answer) {
                bw.write(s + " ");
            }
            bw.write("\n");
            return;
        }
        for (int temp = 1; temp <= n; temp++) {
            answer[length] = temp;
            backTracking(temp, length + 1);
        }
    }
}
