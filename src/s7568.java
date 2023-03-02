import java.io.*;

public class s7568 {
    static Person[] p;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        p = new Person[n];

        initPersonList(n);
        calGrade(n);
        printGrade();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void initPersonList(int n) throws IOException {
        String[] tmp;
        for (int i = 0; i < n; i++) {
            tmp = br.readLine().split(" ");
            p[i] = new Person();
            p[i].w = Integer.parseInt(tmp[0]);
            p[i].h = Integer.parseInt(tmp[1]);
        }
    }

    public static void calGrade(int n) {
        for (int i = 0; i < n; i++) {
            for (int idx = 0; idx < n; idx++) {
                if (i != idx) {
                    if ((p[i].w < p[idx].w) && (p[i].h < p[idx].h)) {
                        p[i].grade++;
                    }
                }
            }
        }
    }

    public static void printGrade() throws IOException {
        for (Person i : p) {
            bw.write(i.grade + " ");
        }
    }
}

class Person {
    int w = 0;
    int h = 0;
    int grade = 1;
}


