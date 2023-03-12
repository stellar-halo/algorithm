package s11650;
import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Point[] p;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        p = new Point[n];
        initPoints(n);
        printSortedPoints(n);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void initPoints(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] tmp;
            p[i] = new Point();
            tmp = br.readLine().split(" ");
            p[i].setX(Integer.parseInt(tmp[0]));
            p[i].setY(Integer.parseInt(tmp[1]));
        }
    }

    public static void printSortedPoints(int n) throws IOException {
        Arrays.sort(p);
        for (int i = 0; i < n; i++) {
            bw.write(p[i].getX() + " " + p[i].getY() + "\n");
        }
    }
}

class Point implements Comparable<Point> {
    int y = 0;
    int x = 0;
    boolean print = false;

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x < o.getX()) return -1;
        else if (this.x > o.getX()) return 1;
        else if (this.x == o.getX()) {
            if (this.y < o.getY()) return -1;
            else return 1;
        }
        return 0;
    }
}
