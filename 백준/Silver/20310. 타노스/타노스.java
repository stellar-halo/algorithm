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

        one = one / 2;
        zero = zero / 2;

        for (int idx = 0; idx < S.length; idx++) {
            if (one > 0 && S[idx].equals("1")) {
                S[idx] = "";
                one--;
            }

            if(one == 0) break;
        }

        for (int idx = S.length - 1; idx >= 0; idx--) {
            if (zero > 0 && S[idx].equals("0")) {
                S[idx] = "";
                zero--;
            }

            if(zero == 0) break;
        }

        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < S.length; idx++) {
            sb.append(S[idx]);
        }

        System.out.println(sb);
    }
}

