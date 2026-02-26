import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] teamMates;
        int[] scoreBoard;
        int[] fifths;
        int[] adds;

        StringTokenizer st;
        while (T > 0) {
            T--;
            teamMates = new int[201];
            scoreBoard = new int[201];
            fifths = new int[201];
            adds = new int[201];

            int N = Integer.parseInt(br.readLine());
            String scores = br.readLine();
            st = new StringTokenizer(scores);

            for (int n = 0; n < N; n++) {
                int team = Integer.parseInt(st.nextToken());
                teamMates[team]++;
                if (teamMates[team] == 5) fifths[team] = n;
            }

            st = new StringTokenizer(scores);
            int score = 1;
            for (int n = 0; n < N; n++) {
                int team = Integer.parseInt(st.nextToken());
                if (teamMates[team] < 6) continue;

                if (adds[team] < 4) {
                    scoreBoard[team] += score;
                    adds[team]++;
                }
                score++;
            }

            int max = Integer.MAX_VALUE;
            int winner = 1;

            for (int idx = 1; idx < 201; idx++) {
                if (scoreBoard[idx] < max && scoreBoard[idx] > 0) {
                    max = scoreBoard[idx];
                    winner = idx;
                } else if (scoreBoard[idx] == max && fifths[idx] < fifths[winner]) {
                    winner = idx;
                }
            }

            System.out.println(winner);
        }
    }
}