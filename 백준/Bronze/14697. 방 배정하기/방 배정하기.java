import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int a, b, c, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
        num = Integer.parseInt(input[3]);

        boolean[] possible = new boolean[num + 1];
        possible[0] = true;

        for (int i = 0; i <= num; i++) {
            if (possible[i]) {
                if (i + a <= num) possible[i + a] = true;
                if (i + b <= num) possible[i + b] = true;
                if (i + c <= num) possible[i + c] = true;
            }
        }

        int answer = possible[num] ? 1 : 0;
        System.out.println(answer);
    }
}
