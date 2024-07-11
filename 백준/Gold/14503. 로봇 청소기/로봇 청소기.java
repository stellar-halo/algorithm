import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int cleaningRoom, direction, r, c, n, m;
    private static boolean[][] isRoomClean;
    private static int[][] rooms;
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
       n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        isRoomClean = new boolean[m][n];
        rooms = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int clean = Integer.parseInt(st.nextToken());
                rooms[i][j] = clean;
                isRoomClean[i][j] = clean == 0;
            }
        }

        while (r > 0) {
            //1. 현재 칸 청소가 가능하면, 청소
            if (isRoomClean[r][c]) {
                isRoomClean[r][c] = false;
                cleaningRoom++;
            }
            //주변 4칸을 조사한다.
            for (int idx = 0; idx < 4; idx++) {
                direction--;
                if (direction < 0) direction = 3;

                int nextX = c + dx[direction];
                int nextY = r + dy[direction];

                //청소 가능한 빈 칸이 있는 경우, 한 칸 전진
                if (isRoomClean[nextY][nextX]) {
                    r = nextY;
                    c = nextX;
                    break;
                }

                //청소 가능한 빈 칸이 없는 경우
                if (!isRoomClean[nextY][nextX] && idx == 3) {
                    int backX = dx[direction] * -1;
                    int backY = dy[direction] * -1;

                    nextX = c + backX;
                    nextY = r + backY;

                    //후진하는 곳이 벽이라면
                    if(rooms[nextY][nextX] == 1){
                        r = -1;
                    }
                    //벽이 아니라면
                    else{
                        r = nextY;
                        c = nextX;
                    }
                }
            }
        }

        System.out.println(cleaningRoom);
    }
}
