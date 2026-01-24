import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1 < N < 10000


        for (int idx = 0; idx < 2666800; idx++) {
            String str = String.valueOf(idx);
            if (str.contains("666")) {
                N--;
                if (N == 0) {
                    System.out.println(idx);
                }
            }
        }
    }
}
