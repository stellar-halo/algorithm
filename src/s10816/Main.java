package s10816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> answer = new LinkedHashMap<>();
        int n = Integer.parseInt(br.readLine());
        String[] sang = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] card = br.readLine().split(" ");

        for (int idx = 0; idx < m; idx++) {
            answer.put(card[idx], 0);
        }

        for (int idx = 0; idx < n; idx++) {
            if (answer.containsKey(sang[idx])) {
                int temp = answer.get(sang[idx]) + 1;
                answer.put(sang[idx], temp);
            }
        }
        for (String key : card) {
            int value = answer.get(key);
            bw.write(value + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
