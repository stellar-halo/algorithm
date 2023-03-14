package s10866;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> q = new ArrayList<>();

        for (int idx = 0; idx < n; idx++) {
            String[] oper = br.readLine().split(" ");
            switch (oper[0]) {
                case "push_front":
                    q.add(0,Integer.parseInt(oper[1]));
                    break;
                case "push_back":
                    q.add(q.size(),Integer.parseInt(oper[1]));
                    break;
                case "pop_front":
                    if (q.isEmpty()) bw.write(-1 + "\n");
                    else {
                        bw.write(q.get(0)+"\n");
                        q.remove(0);
                    }
                    break;
                case "pop_back":
                    if (q.isEmpty()) bw.write(-1 + "\n");
                    else {
                        bw.write(q.get(q.size()-1)+"\n");
                        q.remove(q.size()-1);
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
