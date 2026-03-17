import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] MAP = new int[N][M];
        int[][] visited = new int[N][M];

        int startN = 0;
        int startM = 0;
        int[] moveN = {-1, 0, 1, 0};
        int[] moveM = {0, 1, 0, -1};

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(visited[n], Integer.MAX_VALUE);
            for (int m = 0; m < M; m++) {
                int road = Integer.parseInt(st.nextToken());
                MAP[n][m] = road;

                if (road == 2) {
                    startN = n;
                    startM = m;
                }
            }
        }

        PriorityQueue<Point> points = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        points.add(new Point(startN, startM, 0));

        while (!points.isEmpty()) {
            Point p = points.poll();

            if (visited[p.n][p.m] < p.cost && visited[p.n][p.m] > 0) continue; //이미 최단으로 방문한 경우 넘기기

            for (int i = 0; i < 4; i++) {
                int nextN = p.n + moveN[i];
                int nextM = p.m + moveM[i];
                int nextCost = p.cost + 1;
                if (nextN >= 0 && nextN < N && nextM >= 0 && nextM < M && MAP[nextN][nextM] != 0) {
                    if (visited[nextN][nextM] > nextCost) {
                        points.add(new Point(nextN, nextM, nextCost));
                        visited[nextN][nextM] = nextCost;
                    }
                }
            }
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                int road = visited[n][m];
                if (MAP[n][m] == 2) {
                    System.out.print("0 ");
                } else if (MAP[n][m] == 0) {
                    System.out.print("0 ");
                } else if (road == Integer.MAX_VALUE) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(road + " ");
                }
            }
            System.out.println();
        }
    }

    static class Point {
        int n, m, cost;

        Point(int n, int m, int cost) {
            this.n = n;
            this.m = m;
            this.cost = cost;
        }
    }
}

