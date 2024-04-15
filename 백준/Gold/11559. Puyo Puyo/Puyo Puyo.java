import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    static int combo;
    static boolean isCombo = false;
    static String[][] field = new String[12][6];
    static boolean[][] visited = new boolean[12][6];
    static int[][] search = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Position {
        int x, y;
        String puyo;

        Position(int x, int y, String puyo) {
            this.x = x;
            this.y = y;
            this.puyo = puyo;
        }
    }

    public static void main(String[] args) throws IOException {
        //필드 채우기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int row = 0; row < 12; row++) {
            String line = br.readLine();
            for (int col = 0; col < 6; col++) {
                field[row][col] = String.valueOf(line.charAt(col));
            }
        }

        //터지는 걸 찾고, 터지면 . 으로 변경
        //다시 재탐색 -> while문으로 넣어서 터지는 게 없을 때까지 터트리고, 필드 변경하고를 반복
        //중요한 것: 터지는 것을 어떻게 찾을 것인가? bfs로 찾자. 상하좌우로만 연결되어 있다.

        while (true) {
            isCombo = false;
            visited = new boolean[12][6];
            bfs();
            //터지지 않았다면 멈추기
            if (!isCombo) {
                break;
            }
            //터졌다면 더하기
            else {
                combo++;
                rearrange();
            }
        }
        System.out.println(combo);
    }

    private static void bfs() {
        Queue<Position> q = new LinkedList<>();
        //방문하지 않은 모든 점을 탐색해야 한다, 왜냐면,, 이건 연속적이지 않을 수 있기 때문이다
        for (int r = 0; r < 12; r++) {
            for (int c = 0; c < 6; c++) {
                if (!Objects.equals(field[r][c], ".") && !visited[r][c]) {
                    ArrayList<int[]> comboList = new ArrayList<>();

                    q.add(new Position(r, c, field[r][c]));
                    comboList.add(new int[]{r, c});
                    visited[r][c] = true;
                    while (!q.isEmpty()) {
                        Position p = q.poll();
                        String nowPuyo = field[p.x][p.y];

                        for (int[] move : search) {
                            int nextX = p.x + move[0];
                            int nextY = p.y + move[1];
                            //필드 안에 존재하며, 현재 기준 뿌요와 스트링이 동일하고 방문하지 않았다면
                            if (nextY >= 0 && nextY <= 5 && nextX >= 0 && nextX <= 11 && Objects.equals(field[nextX][nextY], nowPuyo) && !visited[nextX][nextY]) {
                                q.add(new Position(nextX, nextY, nowPuyo));
                                comboList.add(new int[]{nextX, nextY});
                                visited[nextX][nextY] = true;
                            }
                        }
                    }

                    if (comboList.size() >= 4) {
                        for (int[] comboPosition : comboList) {
                            field[comboPosition[0]][comboPosition[1]] = ".";
                            isCombo = true;
                        }
                    }
                }
            }
        }
    }

    private static void rearrange() {
        for (int col = 0; col < 6; col++) {
            int dot = 0;
            for (int row = 11; row >= 0; row--) { // 아래에서 위로 이동
                if (Objects.equals(field[row][col], ".")) {
                    dot++; // 빈 공간 카운트
                } else {
                    if (dot > 0) { // 빈 공간이 있을 경우 이동
                        field[row + dot][col] = field[row][col]; // 뿌요 이동
                        field[row][col] = "."; // 현재 위치를 빈 공간으로 설정
                    }
                }
            }
        }
    }
}
