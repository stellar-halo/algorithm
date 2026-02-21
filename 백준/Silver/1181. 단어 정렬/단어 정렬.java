import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String>[] strings = new ArrayList[51];

        for (int i = 0; i < 51; i++) {
            strings[i] = new ArrayList<>();
        }

        for (int n = 0; n < N; n++) {
            String s = br.readLine();
            if (!strings[s.length()].contains(s)) {
                strings[s.length()].add(s);
            }
        }

        for (int i = 0; i < 51; i++) {
            Collections.sort(strings[i]);

            for (String s : strings[i]) {
                System.out.println(s);
            }
        }
    }
}