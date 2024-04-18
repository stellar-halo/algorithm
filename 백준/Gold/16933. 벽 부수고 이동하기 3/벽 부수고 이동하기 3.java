import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    //낮밤 조건의 추가. 벽을 뚫고 가려면, 낮이어야 한다. 벽을 뚫고 갈 때 cost가 짝수, 홀수인지 판단해서 기다렸다가 가면 될 것 같다.
    //출발할 때 낮이니 1: 낮 -> 벽을 부술 때 짝수라면 +2
    //출발에 1 더해주는 것을 잊지 말자.
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
        mapCost = new int[k + 1][n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        brokeWallBfs();
        int minimum = Integer.MAX_VALUE;
        for (int[][] cost : mapCost) {
            if (cost[n - 1][m - 1] != 0) minimum = Math.min(minimum, cost[n - 1][m - 1]);
        }
        if (minimum == Integer.MAX_VALUE) System.out.println(-1);
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

                //visited 대신 cost로 방문 했는지 , 안했는지 측정 -> 이게 가능했던 이유는 항상 먼저 도달하면 cost가 적었기 때문인데, 이 문제는 낮과 밤의 조건이 더해져서 먼저 도달했다고 해서 cost가 적다고 판단할 수가 없었다.
                //벽을 부순 개수만큼, mapCost를 따로 관리해줘야 함
                //같은 벽을 방문하더라도, 벽을 몇 개를 부수고 방문했는지에 따라 경우가 달라지기 때문
                if (nextY >= 0 && nextY < m && nextX >= 0 && nextX < n) {
                    //벽이 아니라면, 그냥 한 칸 이동
                    if (map[nextX][nextY] == 0) {
                        int cost = mapCost[nowPosition.power][nowPosition.x][nowPosition.y] + 1;
                        //먼저 도달했거나, 이전의 값보다 현재의 값이 더 작다면 갱신!
                        if (mapCost[nowPosition.power][nextX][nextY] == 0 || mapCost[nowPosition.power][nextX][nextY] > cost) {
                            mapCost[nowPosition.power][nextX][nextY] = cost;
                            //힘 안썼으므로, 현재 힘을 그대로 넣어주기
                            q.add(new Position(nextX, nextY, nowPosition.power));
                        }
                    }
                    //벽인데, 힘이 있으면 부수고 이동 + 짝수면 기다리고 갈 것 해줄 것. 2 -> 4
                    else if (map[nextX][nextY] == 1 && nextPower >= 0) {
                        int cost;
                        //짝수니까 반나절 기다림
                        if (mapCost[nowPosition.power][nowPosition.x][nowPosition.y] % 2 == 0) {
                            cost = mapCost[nowPosition.power][nowPosition.x][nowPosition.y] + 2;
                        }
                        //홀수니까 그냥 부숨
                        else {
                            cost = mapCost[nowPosition.power][nowPosition.x][nowPosition.y] + 1;
                        }
                        //먼저 도달했거나, 이전의 값보다 현재의 값이 더 작다면 갱신!
                        if (mapCost[nextPower][nextX][nextY] == 0 || mapCost[nextPower][nextX][nextY] > cost) {
                            mapCost[nextPower][nextX][nextY] = cost;
                            q.add(new Position(nextX, nextY, nextPower));
                        }
                    }
                }
            }
        }
    }
}

