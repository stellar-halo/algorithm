package s7568;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Person[] p = new Person[n];
        String[] tmp;
        for (int i = 0; i < n; i++) {
            tmp = br.readLine().split(" ");
            p[i] = new Person();
            p[i].w = Integer.parseInt(tmp[0]);
            p[i].h = Integer.parseInt(tmp[1]);
        }
        for (int i = 0; i < n; i++) {
            for (int idx = 0; idx < n; idx++) {
                if (i != idx) {
                    if ((p[i].w < p[idx].w) && (p[i].h < p[idx].h)) {
                        p[i].grade++;
                    }
                }
            }
        }

        for (Person i : p) {
            bw.write(i.grade + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Person {
    int w = 0;
    int h = 0;
    int grade = 1;
}


