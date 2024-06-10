import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, m, safetySpace, virus, wall, spreadVirus;
    private static boolean[][] visited;
    private static int[][] map, mapOrigin;
    private static ArrayList<Position> virusPosition;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];
        mapOrigin = new int[n][m];
        virusPosition = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                mapOrigin[i][j] = num;

                //벽이라면
                if (num == 1) {
                    //벽 개수 증가
                    wall++;
                    //빈 곳이어야만 벽을 세울 수 있기 때문에, 빈 곳이 아니라면 방문한 곳으로 처리한다.
                    visited[i][j] = true;
                }

                //바이러스라면
                if (num == 2) {
                    //바이러스 위치 추가
                    virusPosition.add(new Position(i, j));
                    //바이러스 개수 증가
                    virus++;
                    //빈 곳이어야만 벽을 세울 수 있기 때문에, 빈 곳이 아니라면 방문한 곳으로 처리한다.
                    visited[i][j] = true;
                }
            }
        }
        //초기 입력 끝

        initMap();

        // 1. 순열로 벽을 세울 수 잇는 모든 곳에 벽을 세운다
        // 2. 바이러스가 퍼질 수 있는 곳에 최대한 퍼트린다.
        // 3. 안전 구역 크기를 센다.
        permutation(0);
        System.out.println(safetySpace);
    }

    private static void initMap() {
        for (int i = 0; i < n; i++) {
            if (m >= 0) System.arraycopy(mapOrigin[i], 0, map[i], 0, m);
        }
    }

    static void permutation(int depth) {

        if (depth == 3) {
            //퍼진 바이러스의 개수 초기화
            spreadVirus = 0;
            //벽을 3개를 세웠으므로, 2. 바이러스를 최대한 퍼트린다.
            spreadVirus();
            initMap();
            //벽을 세웠던 map을 초기화 시킨다.
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //방문한 적이 없다면
                if (!visited[i][j]) {
                    //방문해서
                    visited[i][j] = true;
                    //벽을 세우고
                    mapOrigin[i][j] = 1;
                    //재귀 호출
                    permutation(depth + 1);
                    visited[i][j] = false;
                    mapOrigin[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus() {
        //각각 모든 바이러스의 위치에서 바이러스가 퍼질 수 있는지 검사한다.
        for (Position p : virusPosition) {
            Queue<Position> q = new LinkedList<>();
            q.add(p);

            while (!q.isEmpty()) {
                Position now = q.poll();
                for (int idx = 0; idx < 4; idx++) {
                    int nextX = now.x + dx[idx];
                    int nextY = now.y + dy[idx];

                    //지도의 크기를 넘지 않고
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                        //빈 지대라면
                        if (map[nextX][nextY] == 0) {
                            //바이러스가 옮고
                            map[nextX][nextY] = 2;
                            //퍼진 바이러스의 개수가 증가한다.
                            spreadVirus++;
                            //다음 탐색으로 추가
                            q.add(new Position(nextX, nextY));
                        }
                    }
                }
            }
        }

        // 3. 각 위치의 벽을 세웠을 때, 안전 지대의 개수를 구한다.
        int curSafetySpace = (n * m) - wall - virus - spreadVirus - 3;
        if (curSafetySpace > safetySpace) safetySpace = curSafetySpace;
    }
}
