import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static private int n, m, k;
    static private int[][] cornfield;
    static private boolean[][] visited;
    static private ArrayList<Corn> highestCostCorns;
    static private int[] dx = {0, -1, 1, 0};
    static private int[] dy = {1, 0, 0, -1};

    static private class Corn implements Comparable<Corn> {
        int i, j, cost;

        Corn(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }

        @Override
        public int compareTo(Corn o) {
            return o.cost - this.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cornfield = new int[n][m];
        visited = new boolean[n][m];
        highestCostCorns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cornfield[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        k = Integer.parseInt(br.readLine());
        //초기 입력 완료

        PriorityQueue<Corn> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) { //첫 줄이면 전부 다 인접한 행
                for (int j = 0; j < m; j++) {
                    pq.add(new Corn(i, j, cornfield[i][j]));
                }
            } else if (i == n - 1) { //마지막 줄이면 전부 다 인접한 행
                for (int j = 0; j < m; j++) {
                    pq.add(new Corn(i, j, cornfield[i][j]));
                }
            } else { //그 외에는 맨 앞, 맨 뒤만 넣어준다.
                pq.add(new Corn(i, 0, cornfield[i][0]));
                pq.add(new Corn(i, m - 1, cornfield[i][m - 1]));
            }
        }

        while (highestCostCorns.size() < k) {
            Corn highestCostCorn = pq.poll();
            //우선순위큐를 이용해서 가장 비싼 옥수수를 poll / 혹시 우선순위 큐에 두 번 들어갔을 때를 대비하여, 방문하지 않았으면 리스트에 추가
            if (!visited[highestCostCorn.i][highestCostCorn.j]) highestCostCorns.add(highestCostCorn);
            //방문한 것으로 처리
            visited[highestCostCorn.i][highestCostCorn.j] = true;

            //bfs
            for (int idx = 0; idx < 4; idx++) {
                int nextY = highestCostCorn.i + dy[idx];
                int nextX = highestCostCorn.j + dx[idx];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (!visited[nextY][nextX]) pq.add(new Corn(nextY, nextX, cornfield[nextY][nextX]));
                }
            }
        }

        //나는 인덱스가 1 적기 때문에 한개씩 더해서 출력
        for (Corn corn : highestCostCorns) {
            System.out.println((corn.i + 1) + " " + (corn.j + 1));
        }
    }
}
