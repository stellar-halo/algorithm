import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int m, n, days, unripeTomatoes;
    private static int[][] tomatoBox;
    private static boolean[][] visited;
    private static int[] dJ = {-1, 0, 1, 0};
    private static int[] dI = {0, 1, 0, -1};
    private static Queue<Box> q;

    private static class Box {
        private int i, j, days;

        public Box(int i, int j, int days) {
            this.i = i;
            this.j = j;
            this.days = days;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomatoBox = new int[n][m];
        visited = new boolean[n][m];
        q = new LinkedList<>();
        unripeTomatoes = -1;
        days = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                tomatoBox[i][j] = tomato;
                if (tomato == 0) {
                    if (unripeTomatoes == -1) {
                        unripeTomatoes = 0;
                    }
                    unripeTomatoes++;
                } else if (tomato == 1) {
                    q.add(new Box(i, j, 0));
                }
            }
        }

        dfs();

        if (unripeTomatoes == -1) {
            System.out.println("0");
        } else if (unripeTomatoes == 0) {
            System.out.println(days);
        } else {
            System.out.println("-1");
        }
    }

    private static void dfs() {
        while (!q.isEmpty()) {
            Box b = q.poll();
            for (int idx = 0; idx < 4; idx++) {
                int nextI = b.i + dI[idx];
                int nextJ = b.j + dJ[idx];

                if (nextI < n && nextI >= 0 && nextJ < m && nextJ >= 0) {
                    if (tomatoBox[nextI][nextJ] == 0 && !visited[nextI][nextJ]) {
                        unripeTomatoes--;
                        visited[nextI][nextJ] = true;
                        tomatoBox[nextI][nextJ] = 1;
                        q.add(new Box(nextI, nextJ, b.days + 1));
                        days = Math.max(b.days + 1, days);
                    }
                }
            }
        }
    }
}
