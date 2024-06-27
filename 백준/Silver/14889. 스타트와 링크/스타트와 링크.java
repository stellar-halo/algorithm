import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static private int n, startPower, linkPower, powerDiff;
    static private int[][] powerList;
    static private int[] teamList;
    static final int START = 0;
    static final int LINK = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        powerList = new int[n][n];
        teamList = new int[n];
        powerDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                powerList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(powerDiff);
    }

    private static void combination(int count, int start) {
        int max = n / 2;
        if (count == max) {
            countTeamPower();
            return;
        }
        for (int i = start; i < n; i++) {
            teamList[i] = LINK;
            combination(count + 1, i + 1);
            teamList[i] = START;
        }
    }

    private static void countTeamPower() {
        startPower = 0;
        linkPower = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //자기 자신이 아니고 team이 같을 때
                if (i != j && (teamList[i] == teamList[j])) {
                    if (teamList[i] == START)
                        startPower += powerList[i][j];
                    else
                        linkPower += powerList[i][j];
                }
            }
        }
        powerDiff = Math.min(powerDiff, Math.abs((linkPower - startPower)));
    }
}
