import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split("");
        int one = 0;
        int zero = 0;
        for (int idx = 0; idx < S.length; idx++) {
            if (S[idx].equals("1")) {
                one++;
            } else {
                zero++;
            }
        }
        StringBuilder sb = new StringBuilder();
        one = one / 2;
        zero = zero / 2;

        while (zero > 0) {
            zero--;
            sb.append("0");
        }

        while (one > 0) {
            one--;
            sb.append("1");
        }

        System.out.println(sb);
    }
}

