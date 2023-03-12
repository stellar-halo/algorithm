package b4153;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] tri = br.readLine().split(" ");
            if (Objects.equals(tri[0], "0")) break;
            else {
                int a = Integer.parseInt(tri[0]);
                int b = Integer.parseInt(tri[1]);
                int c = Integer.parseInt(tri[2]);

                int ausar = -1;
                int auset = -1;
                int heru = -1;

                if (a > b && a > c) {
                    heru = a;
                    ausar = b;
                    auset = c;
                } else if (b > a && b > c) {
                    heru = b;
                    ausar = a;
                    auset = c;
                } else if(c > a && c > b) {
                    heru = c;
                    ausar = a;
                    auset = b;
                }

                if (heru * heru == ausar * ausar + auset * auset) bw.write("right\n");
                else bw.write("wrong\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
