import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static private int n, k, count;
    static private int[] exerciseKits;
    static private boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        exerciseKits = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            exerciseKits[i] = Integer.parseInt(st.nextToken());
        }

        exercise(0, 500);
        System.out.println(count);
    }

    static private void exercise(int depth, int currentWeight) {
        if (currentWeight < 500) {
            return;
        }
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                exercise(depth + 1, currentWeight - k + exerciseKits[i]);
                visited[i] = false;
            }
        }
    }
}
