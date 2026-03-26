import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, N;
    static int[][] MAP;
    static boolean[][] visited;
    static boolean[][] combined;
    static boolean isCombined;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int date = 0;

        combined = new boolean[N][N];
        MAP = new int[N][N];
        isCombined = true;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (isCombined) {
            isCombined = false; //연합 아직 안함
            visited = new boolean[N][N]; //방문 초기화

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        dfs(i, j);
                    }
                }
            }

            if (isCombined) date++; //연합 했으면 연합일 추가
        }

        System.out.println(date);
    }

    public static void dfs(int r, int c) {
        Queue<Nation> q = new LinkedList<>();
        LinkedList<int[]> union = new LinkedList<>();
        int sum = MAP[r][c];

        visited[r][c] = true;
        q.add(new Nation(r, c));
        union.add(new int[]{r, c});

        while (!q.isEmpty()) { //연합국 구하기
            Nation n = q.poll();
            for (int idx = 0; idx < 4; idx++) { //인접한 국가 방문하기
                int nr = n.r + dr[idx];
                int nc = n.c + dc[idx];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue; //  방벽 밖의 국가면 넘어가기
                if (visited[nr][nc]) continue;// 방문했으면 넘어가기

                int diff = Math.abs(MAP[n.r][n.c] - MAP[nr][nc]); // 인구수 차이

                if (diff >= L && diff <= R) { // 두 나라의 인구 차이가 L명 이상, R명 이하 = 연합국
                    visited[nr][nc] = true;
                    union.offer(new int[]{nr, nc});
                    q.add(new Nation(nr, nc)); // 큐에 추가
                    sum += MAP[nr][nc]; //합계에 추가
                }


            }
        }


        if (union.size() > 1) {
            int avg = sum / union.size();
            isCombined = true;

            for (int[] n : union) {
                MAP[n[0]][n[1]] = avg;
            }
        }
    }

    static class Nation {
        int r, c;

        Nation(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

