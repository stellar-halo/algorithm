package s17219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        Map<String, String> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] sitePassword = br.readLine().split(" ");
            String site = sitePassword[0];
            String password = sitePassword[1];
            memo.put(site, password);
        }

        for (int i = 0; i < m; i++) {
            bw.write(memo.get(br.readLine())+ "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
