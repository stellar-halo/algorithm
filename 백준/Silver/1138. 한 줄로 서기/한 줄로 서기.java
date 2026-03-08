import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] leftPerson = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> line = new LinkedList<>();
        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(st.nextToken());
            leftPerson[n] = num;
        }

        for (int n = N; n > 0; n--) {
            if (n == N) {
                line.add(n);
            } else {
                line.add(leftPerson[n - 1], n);
            }
        }

        for (int p : line) {
            System.out.print(p + " ");
        }
    }
}