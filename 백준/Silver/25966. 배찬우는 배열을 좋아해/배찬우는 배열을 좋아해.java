import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String[] nmq = br.readLine().split(" ");
        int n = Integer.parseInt(nmq[0]);
        int m = Integer.parseInt(nmq[1]);
        int q = Integer.parseInt(nmq[2]);
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) { //보드판 입력 받음
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int temp = 0; temp < q; temp++) {//쿼리 처리
            String[] query = br.readLine().split(" ");
            int i = Integer.parseInt(query[1]);
            int j = Integer.parseInt(query[2]);
            if (query.length == 4) { // 0 i j k
                int k = Integer.parseInt(query[3]);
                board[i][j] = k;
            } else if (query.length == 3) { // 1 i j
                int[] tempRow = board[i];
                board[i] = board[j];
                board[j] = tempRow;
            }
        }

        for (int[] r : board) {
            for (int c : r) {
                bw.write(c+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
