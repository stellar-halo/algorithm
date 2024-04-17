import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    //탐색을 하되, 벽을 만나고 k가 1보다 크면 벽을 뿌수고 이동.
    static private int n, m, k;
    static private int[][][] mapCost;
    static private int[][] map;
    static private int[] dx = {0, 1, -1, 0};
    static private int[] dy = {1, 0, 0, -1};

    private static class Position {
        int x, y, power;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Position(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        map = new int[n][m];
        mapCost = new int[k+1][n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        brokeWallBfs();
        int minimum = Integer.MAX_VALUE;
        for(int[][] cost: mapCost){
            if (cost[n - 1][m - 1] != 0) minimum = Math.min(minimum, cost[n - 1][m - 1]);
        }
        if(minimum == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minimum);
    }

    static private void brokeWallBfs() {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0, 0, k));
        for (int i = 0; i <= k; i++) {
            mapCost[i][0][0] = 1;
        }
        while (!q.isEmpty()) {
            Position nowPosition = q.poll();
            for (int tmp = 0; tmp < 4; tmp++) {
                int nextX = nowPosition.x + dx[tmp];
                int nextY = nowPosition.y + dy[tmp];
                int nextPower = nowPosition.power - 1;

                //visited 대신 cost로 방문 했는지 , 안했는지 측정
                //벽을 부순 개수만큼, mapCost를 따로 관리해줘야 함
                //같은 벽을 방문하더라도, 벽을 몇 개를 부수고 방문했는지에 따라 경우가 달라지기 때문
                if (nextY >= 0 && nextY < m && nextX >= 0 && nextX < n) {
                    //벽인데, 힘이 있으면 부수고 이동
                    if (map[nextX][nextY] == 1 && nextPower >= 0 && mapCost[nextPower][nextX][nextY] == 0) {
                        mapCost[nextPower][nextX][nextY] = mapCost[nowPosition.power][nowPosition.x][nowPosition.y] + 1;
                        q.add(new Position(nextX, nextY, nextPower));
                    }
                    //벽이 아니라면, 그냥 한 칸 이동
                    else if (map[nextX][nextY] == 0 && mapCost[nowPosition.power][nextX][nextY] == 0) {
                        mapCost[nowPosition.power][nextX][nextY] = mapCost[nowPosition.power][nowPosition.x][nowPosition.y] + 1;
                        //힘 안썼으므로, 현재 힘을 그대로 넣어주기
                        q.add(new Position(nextX, nextY, nowPosition.power));
                    }
                }
            }
        }
    }
}
