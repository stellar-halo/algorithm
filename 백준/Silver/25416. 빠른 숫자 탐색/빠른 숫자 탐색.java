import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int board[][], result;
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[5][5];
        visited = new boolean[5][5];
        result = -1;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bfs(r, c);

        System.out.println(result);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];

                if (x >= 0 && x < 5 && y >= 0 && y < 5 && !visited[x][y] && board[x][y] != -1) {
                    if (board[x][y] == 1) {
                        result = temp[2] + 1;
                        break;
                    }
                    visited[x][y] = true;
                    queue.add(new int[]{x, y, temp[2] + 1});
                }
            }
            if (result != -1)
                break;
        }
    }
}
