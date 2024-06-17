import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Main {
    private static int n, leftArm, rightArm, leftLeg, rightLeg, waist, headX, headY;
    private static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new String[n][n];
        for (int idx = 0; idx < n; idx++) {
            board[idx] = br.readLine().split("");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j].equals("*")) {
                    //머리 차례면 머리 할당
                    if (headX == 0) {
                        headX = j;
                        headY = i;
                        //머리는 하나니까 다음 줄로
                        break;
                    } else {
                        //아직 팔 길이 측정 중이라면, 이번 줄은 팔 길이 줄!
                        if (leftArm == 0) {
                            findArm(i);
                            break;
                        } else {
                            //허리, 다리는 전부 다른 인덱스에 잇기 때문에 동시에 측정이 가능하다.
                            if (j == headX) waist++;
                            else if (j < headX) leftLeg++;
                            else rightLeg++;
                        }
                    }
                }
            }
        }
        System.out.println((headY + 2) + " " + (headX + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }

    private static void findArm(int idx) {
        boolean cookie = false;
        for (int i = 0; i < n; i++) {
            if (board[idx][i].equals("*")) {
                if (!cookie) {
                    cookie = true;
                    leftArm = headX - i;
                }
            } else {
                if (cookie) {
                    rightArm = i - headX - 1;
                    break;
                }
            }
        }
        if (rightArm == 0) rightArm = n - headX - 1;
    }
}
