package s10845;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static public void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> q = new ArrayList<>();
        for (int idx = 0; idx < n; idx++) {
            String[] oper = br.readLine().split(" ");
            switch (oper[0]) {
                case "push":
                    q.add(Integer.parseInt(oper[1]));
                    break;
                case "pop":
                    if (q.isEmpty()) bw.write(-1 + "\n");
                    else {
                        bw.write(q.get(0)+"\n");
                        q.remove(0);
                    }
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    if (q.isEmpty()) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case "front":
                    if (q.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(q.get(0) + "\n");
                    break;
                case "back":
                    if (q.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(q.get(q.size()-1) + "\n");
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}