import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, minimum, chickenDistance;
    static int[][] map;
    static int[][] distance;
    static boolean[] visited;
    static ArrayList<Position> homeList;
    static ArrayList<Position> chickenList;

    static private class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        //초기 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        minimum = Integer.MAX_VALUE;
        map = new int[n][n];
        homeList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[row][col] = tmp;
                if (tmp == 1) homeList.add(new Position(row, col));
                if (tmp == 2) chickenList.add(new Position(row, col));
            }
        }
        visited = new boolean[chickenList.size()];

        //각 집에서 치킨집까지의 거리를 전부 구한다.
        //치킨집이 열, 집이 행 -> int[집 개수][치킨집 개수]
        distance = new int[homeList.size()][chickenList.size()];
        for (int home = 0; home < homeList.size(); home++) {
            for (int chicken = 0; chicken < chickenList.size(); chicken++) {
                Position c = chickenList.get(chicken);
                Position h = homeList.get(home);
                distance[home][chicken] = (Math.abs(c.x - h.x) + Math.abs(c.y - h.y));
            }
        }

        //만일 치킨집이 1개, 2개,,, m개 라면?
        //m개의 치킨집이 살아있는 것을 어떻게 구해야 하는가,, -> 조합 -> 백트래킹
        //m개의 치킨집을 조합으로 구하고, 각 집이 그 m개의 치킨집까지의 거리 중 최소값들만을 더한 값을 구하자.
        //치킨집 조합 구하기
        int[] selectedChicken = new int[m];
        combination(selectedChicken, 0, 0);

        System.out.println(minimum);
    }
    static private void combination(int[] selectedChicken, int idx, int start) {
        //m개를 골라두고 구해도 되는 이유는, 가게 개수를 뽑아내라고 하지 않았기 때문이다..!!!
        if (idx == m) {
            // 각 집마다 선택된 치킨 집까지의 최소 거리를 계산
            int sum = 0;
            for (int i = 0; i < homeList.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    minDistance = Math.min(minDistance, distance[i][selectedChicken[j]]);
                }
                sum += minDistance;
            }
            // 최소 치킨 거리 업데이트
            minimum = Math.min(minimum, sum);
            return;
        }

        // 조합 구하기
        for (int i = start; i < chickenList.size(); i++) {
            selectedChicken[idx] = i;
            combination(selectedChicken, idx + 1, i + 1);
        }
    }
}
