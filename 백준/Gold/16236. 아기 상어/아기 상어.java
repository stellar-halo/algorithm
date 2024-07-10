import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    private static int sec, babySharkSize, fishCount, n;
    private static Position babySharkPosition;
    private static int[][] oceanMap;
    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {-1, 0, 0, 1};

    private static class Position {
        private int x, y, dist;

        public Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        oceanMap = new int[n][n];
        babySharkSize = 2;
        fishCount = 0;

        // 기본 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    babySharkPosition = new Position(j, i, 0);
                    num = 0;
                }
                oceanMap[i][j] = num;
            }
        }

        while (true) {
            Position fish = searchFish();
            if (fish == null) {
                System.out.println(sec);
                return;
            }

            sec += fish.dist;
            fishCount++;
            if (fishCount == babySharkSize) {
                babySharkSize++;
                fishCount = 0;
            }

            oceanMap[fish.y][fish.x] = 0;
            babySharkPosition = new Position(fish.x, fish.y, 0);
        }
    }

    private static Position searchFish() {
        //매번 먹을 물고기를 찾을 때마다 초기화
        boolean[][] visited = new boolean[n][n];
        Queue<Position> q = new LinkedList<>();
        //가장 왼쪽 위의 물고기를 먹어야 하기 때문에, 다 먹을 수 있는 물고기 리스트에서 우선순위 큐를 이용해주면 된다.
        PriorityQueue<Position> fishList = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position p1, Position p2) {
                if (p1.dist == p2.dist) {
                    if (p1.y == p2.y) {
                        return p1.x - p2.x;
                    }
                    return p1.y - p2.y;
                }
                return p1.dist - p2.dist;
            }
        });

        q.add(babySharkPosition);
        visited[babySharkPosition.y][babySharkPosition.x] = true;

        while (!q.isEmpty()) {
            Position now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                //탐색순이 아니라 거리순으로 비교해야 되기 때문에 dist를 Position과 같이 저장해주면 된다.
                int nextDist = now.dist + 1;

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    int fishSize = oceanMap[nextY][nextX];

                    if (fishSize == 0 || fishSize == babySharkSize) {
                        q.add(new Position(nextX, nextY, nextDist));
                    } else if (fishSize < babySharkSize) {
                        fishList.add(new Position(nextX, nextY, nextDist));
                    }
                }
            }
        }

        return fishList.poll();
    }
}
