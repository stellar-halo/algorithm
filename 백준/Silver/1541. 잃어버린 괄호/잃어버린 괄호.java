import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isPlus = true;
        int sum = 0;
        int temp = 0;

        String[] line = br.readLine().split("");

        for (String s : line) {
            char c = s.charAt(0);

            if (Character.isDigit(c)) { //숫자면
                temp = temp * 10 + Integer.parseInt(s);
            } else { //기호일 때

                if (isPlus) { //더하기 상황일 때
                    sum += temp;
                }else{ //빼기 상황일 때
                    sum -= temp;
                }

                if (s.equals("-")) {
                    isPlus = false;
                }

                temp = 0;
            }
        }

        if (isPlus) { //더하기 상황일 때
            sum += temp;
        }else{ //빼기 상황일 때
            sum -= temp;
        }

        System.out.println(sum);
    }

}
