import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        visited = new boolean[n + 1];
        answer = new int[m];

        backTracking(0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int length) throws IOException {
        if (length == m) {
            for (int s : answer) {
                bw.write(s + " ");
            }
            bw.write("\n");
            return;
        }
        for (int temp = 1; temp <= n; temp++) {
            if (visited[temp]) continue;
            answer[length] = temp;
            visited[temp] = true;
            backTracking(length+1);
            visited[temp] = false;
        }
    }
}
