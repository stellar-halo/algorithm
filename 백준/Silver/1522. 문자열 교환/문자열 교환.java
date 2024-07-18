import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sentence = br.readLine().split("");
        int a = 0;
        int b = 0;
        int diff = Integer.MAX_VALUE;

        for (String s : sentence) {
            if (s.equals("a")) a++;
            else b++;
        }

        for (int i = 0; i < sentence.length; i++) {
            int tempDiff = 0;
            for (int j = 0; j < a; j++) {
                int idx = i + j;
                if (idx >= sentence.length) {
                    idx = idx - sentence.length;
                }

                if (sentence[idx].equals("b")) {
                    tempDiff++;
                }
            }
            diff = Math.min(tempDiff, diff);
        }

        System.out.println(diff);
    }
}
