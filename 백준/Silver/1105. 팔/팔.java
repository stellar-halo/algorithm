import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int llen = input[0].length();
        int rlen = input[1].length();
        int diff = rlen - llen;
        String[] L = input[0].split("");
        String[] R = input[1].split("");
        int ans = 0;

        if(llen == rlen) {
            for (int idx = 0; idx < rlen; idx++) {
                if (Objects.equals(L[idx], R[idx])) {
                    if (Integer.parseInt(L[idx]) == 8) ans++;
                } else break;
            }
        }

        System.out.println(ans);
    }
}
