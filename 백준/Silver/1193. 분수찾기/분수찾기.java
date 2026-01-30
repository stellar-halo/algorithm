import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int a = 0;
        int b = 0;
        for (int idx = 1; idx < 5000; idx++) {
            sum += idx;
            if (sum >= N) {
                sum -= idx;
                N -= sum;
                if (idx % 2 == 1) { //홀수
                    a = idx + 1 - N;
                    b = N;

                } else { //짝수
                    a = N;
                    b = idx + 1 - N;
                }
                break;
            }
        }

        System.out.println(a + "/" + b);
    }
}
