import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, a, b, m, answer;
    private static ArrayList<Integer>[] relatives;
    private static boolean[][] visited;

    private static class Relative {
        private int p, r;

        public Relative(int p, int r) {
            this.p = p;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        answer = -1;
        relatives = new ArrayList[n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            relatives[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            relatives[parent].add(child);
            relatives[child].add(parent);
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Relative> q = new LinkedList<>();
        q.add(new Relative(a, 0));

        while (!q.isEmpty()) {
            Relative r = q.poll();
            if (r.p == b) {
                answer = r.r;
                return;
            } else {
                int num = relatives[r.p].size();
                for (int i = 0; i < num; i++) {
                    if (!visited[r.p][relatives[r.p].get(i)]) {
                        q.add(new Relative(relatives[r.p].get(i), r.r + 1));
                        visited[r.p][relatives[r.p].get(i)] = true;
                        visited[relatives[r.p].get(i)][r.p] = true;
                    }
                }
            }
        }
    }
}
