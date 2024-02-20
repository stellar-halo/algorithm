import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String board = br.readLine();
        int boardSize = board.length();
        int count = 0;
        String[] boardSpaces = board.split("");

        for (int idx = 0; idx < boardSize; idx++) {
            if (Objects.equals(boardSpaces[idx], "X")) { //X라면
                count++; //X개수 하나 올리고
                boardSpaces[idx] = "A";
                if (idx == boardSize - 1) { //X만 나오다가 끝나는 경우
                    if (count % 2 == 0) { //count가 짝수인지 판별
                        int bCount = (count % 4) / 2; //b는 어짜피 0개 아니면 1개이다. b는 몇 개인지
                        for (int temp = bCount * 2; temp > 0; temp--) {
                            boardSpaces[idx - temp + 1] = "B";
                        }
                    }
                }
            } else { //.이 나온다면
                if (count % 2 == 0) { //count가 짝수인지 판별
                    int bCount = (count % 4) / 2; //b는 어짜피 0개 아니면 1개이다. b는 몇 개인지
                    for (int temp = bCount * 2; temp > 0; temp--) {
                        boardSpaces[idx - temp] = "B";
                    }
                    //초기화
                    count = 0;
                } else { //홀수개 for문 중단
                    break;
                }
            }
        }

        if (count%2==0) {
            for (String item : boardSpaces) {
                bw.write(item + "");
            }
        }
        else{
            bw.write(-1+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
