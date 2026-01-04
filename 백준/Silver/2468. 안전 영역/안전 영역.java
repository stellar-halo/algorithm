import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int maximumSafetyLand = 0;
    static int safetyLand = 0;
    static boolean IsSafety = false;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] visited;
    static int[][] map;
    static int n = 0;
    static int maximum = 0;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //지역 크기
        visited = new int[n][n];
        map = new int[n][n];

        //기본 정보 찾기
        for(int i = 0 ; i < n ; i++){
            String[] height = br.readLine().split(" "); //한 줄 입력 받기
            for(int j = 0 ; j < n ; j++){
                int rain = Integer.parseInt(height[j]); //한 지역에 비가 내린 양
                maximum = Math.max(maximum, rain); //가장 많은 비의 양을 구하기 (다 침수된 경우)
                map[i][j] = rain; //지도 완성하기
            }
        }

        //비가 0부터 ~ maximum까지 내릴때의 최대 안전한 영역 개수 찾기
        for(int tmp = 0 ; tmp <= maximum ; tmp++){
            safetyLand = 0;

            //visited 초기화 하기
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    visited[i][j] = 0;
                }
            }

            //tmp만큼 비가 올 때 안전 영역 개수 찾기
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(visited[i][j] == 0 && map[i][j] >tmp) { //방문하지 않았고 침수되지 않은 영역인 경우
                        bfs(i, j, tmp); //영역 너비 탐색
                        safetyLand++;
                    }
                }
            }
            maximumSafetyLand = Math.max(maximumSafetyLand, safetyLand); //최대 안전한 영역 찾기
        }

        System.out.println(maximumSafetyLand);
    }

    public static void bfs(int i, int j, int h){
        q.offer(new Point(i, j));
        visited[i][j] = 1; //방문 완료

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int tmp = 0; tmp < 4 ; tmp++){
                //다음으로 이동
                int nx = p.x + dx[tmp];
                int ny = p.y + dy[tmp];

                // 맵을 넘어가지 않는 경우에만 안전 영역인지 확인
                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    //방문하지 않았고 안잠긴 상태에만 큐에 넣기
                    if( (visited[nx][ny] == 0) && map[nx][ny] > h){
                        IsSafety = true; //영역 존재
                        q.offer(new Point(nx, ny));
                    }
                    visited[nx][ny] = 1;
                }
            }
        }

    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}