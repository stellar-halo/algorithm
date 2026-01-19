import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<DOT> dots = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            dots.add(new DOT(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        while (!dots.isEmpty()) {
            DOT d = dots.poll();
            sb.append(d.x).append(" ").append(d.y).append("\n");
        }

        System.out.print(sb);
    }

    public static class DOT implements Comparable<DOT> {
        int x, y;

        DOT(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(DOT d) {
            if (d.y == this.y) {
                return this.x - d.x;
            } else {
                return this.y - d.y;
            }
        }
    }
}
