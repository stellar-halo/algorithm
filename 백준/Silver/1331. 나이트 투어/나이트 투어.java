import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String[] knightPath;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        knightPath = new String[36];
        visited = new boolean[6][6];
        for (int i = 0; i < 36; i++) {
            knightPath[i] = br.readLine();
        }

        // 나이트의 이동 방법
        // 알파벳 +-2, 숫자 +-1
        // 알파벳 +-1, 숫자 +-2

        for (int i = 0; i < 36; i++) {
            int r = knightPath[i].charAt(0) - 'A';
            int c = knightPath[i].charAt(1) - '1';
            if (visited[r][c]) {
                System.out.println("Invalid");
                return;
            }
            visited[r][c] = true;
            if (i != 35) {
                int nextR = knightPath[i + 1].charAt(0) - 'A';
                int nextC = knightPath[i + 1].charAt(1) - '1';

                if (Math.abs(nextR - r) == 2 && Math.abs(nextC - c) == 1) {
                    // Valid move
                } else if (Math.abs(nextR - r) == 1 && Math.abs(nextC - c) == 2) {
                    // Valid move
                } else {
                    System.out.println("Invalid");
                    return;
                }
            } else {
                int nextR = knightPath[0].charAt(0) - 'A';
                int nextC = knightPath[0].charAt(1) - '1';
                if (Math.abs(nextR - r) == 2 && Math.abs(nextC - c) == 1) {
                    System.out.println("Valid");
                } else if (Math.abs(nextR - r) == 1 && Math.abs(nextC - c) == 2) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Invalid");
                }
            }
        }
    }
}
