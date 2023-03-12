package s2164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> deck = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            deck.offer(i);
        }

        while (deck.size() > 1) {
            deck.remove();
            deck.add(deck.poll());
        }
        bw.write(deck.poll() + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
