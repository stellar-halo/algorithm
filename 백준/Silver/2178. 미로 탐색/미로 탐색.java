import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] moveX = new int[]{-1, 0, 0, 1};
        int[] moveY = new int[]{0, -1, 1, 0};

        for (int row = 0; row < n; row++) {

            String[] line = br.readLine().split("");
            for (int col = 0; col < m; col++) {
                maze[row][col] = Integer.parseInt(line[col]);
            }
        }

        while (!q.isEmpty()) {
            int[] currentState = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = moveX[i];
                int y = moveY[i];
                int nextX = x + currentState[0];
                int nextY = y + currentState[1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (visited[nextX][nextY] || maze[nextX][nextY] == 0) {
                    continue;
                }
                q.add(new int[]{nextX, nextY});
                maze[nextX][nextY] = maze[currentState[0]][currentState[1]] + 1;
                visited[nextX][nextY] = true;
            }
        }

        bw.write(maze[n - 1][m - 1]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
