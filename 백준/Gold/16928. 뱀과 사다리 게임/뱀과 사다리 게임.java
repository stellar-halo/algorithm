import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] board = new int[101];
    static int[] snake = new int[101];
    static int[] ladder = new int[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Arrays.fill(board, Integer.MAX_VALUE);

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            ladder[start] = next;
            board[start] = -1;
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            snake[start] = next;
            board[start] = -1;
        }

        dfs();

        System.out.println(board[100]);

    }

    static void dfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.add(new Point(1, 0));

        while (!pq.isEmpty()) {
            Point nowP = pq.poll();

            if (board[nowP.p] == -1) continue;
            if (board[nowP.p] <= nowP.depth) continue;

            board[nowP.p] = nowP.depth;

            for (int dice = 1; dice < 7; dice++) {
                int nextIdx = nowP.p + dice;
                int nextDepth = nowP.depth + 1;

                if (nextIdx > 100) break;


                int fall = snake[nextIdx]; //snake가 있으면 무조건 snake를 이용해야 한다.
                if (fall != 0 && board[fall] > nextDepth) {
                    pq.add(new Point(fall, nextDepth));
                    continue;
                }

                int destination = ladder[nextIdx]; //사다리가 있으면 무조건 사다리를 이용해야 한다.
                if (destination != 0 && board[destination] > nextDepth) {
                    pq.add(new Point(destination, nextDepth));
                    continue;
                }

                if (board[nextIdx] > nextDepth) {
                    pq.add(new Point(nextIdx, nextDepth));
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int depth, p;

        Point(int p, int depth) {
            this.depth = depth;
            this.p = p;
        }

        @Override
        public int compareTo(Point o) {
            return this.depth - o.depth;
        }
    }
}