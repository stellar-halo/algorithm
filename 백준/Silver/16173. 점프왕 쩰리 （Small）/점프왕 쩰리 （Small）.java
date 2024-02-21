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

        boolean fail = true;
        int boardSize = Integer.parseInt(br.readLine());
        int[][] board = new int[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            String boardLine = br.readLine();
            String[] boardLineStr = boardLine.split(" ");
            int col = 0;
            for (String b : boardLineStr) {
                int max = Math.max(boardSize - row - 1, boardSize - col - 1);
                if (Integer.parseInt(b) > max) board[row][col] = 0;
                else board[row][col] = Integer.parseInt(b);
                col++;
            }
        }

        Queue<Spot> q = new LinkedList<>();
        q.offer(new Spot(0, 0));
        while (!q.isEmpty()) {
            Spot spot = q.poll();
            if (board[spot.row][spot.col] == 0) { //0이면 돌아가기, 다른 q 뽑아본다는 이야기
                continue;
            }
            if (board[spot.row][spot.col] == -1) {//-1이면 성공!
                bw.write("HaruHaru");
                fail = false;
                break;
            }

            int move = board[spot.row][spot.col]; //다른 숫자인 경우
            if (spot.row + move < boardSize) {
                q.offer(new Spot(spot.row + move, spot.col));
            }
            if (spot.col + move < boardSize) {
                q.offer(new Spot(spot.row, spot.col + move));
            }
        }
        if (fail) {
            bw.write("Hing");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Spot {
    int row;
    int col;

    Spot(int r, int c) {
        this.row = r;
        this.col = c;
    }
}
