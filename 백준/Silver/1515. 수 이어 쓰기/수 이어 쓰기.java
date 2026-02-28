import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int idx = 0;
        int max = 0;
        String maxS;
        while (idx < line.length()) {
            max++;
            maxS = max + "";

            for (int i = 0; i < maxS.length(); i++) {
                if (maxS.charAt(i) == line.charAt(idx)) {
                    idx++;
                    if (idx == line.length()) break;
                }
            }
        }

        System.out.println(max);
    }
}