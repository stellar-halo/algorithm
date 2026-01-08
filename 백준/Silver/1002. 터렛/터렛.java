import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static char[][] tree = new char[26][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int r1 = 0;
        int r2 = 0;
        double d = 0;
        Point p1, p2;

        for (int t = 0; t < T; t++) {
            ArrayList<Point> points = new ArrayList<>();
            String[] temps = br.readLine().split(" ");
            int ans = 0;
            p1 = new Point(Integer.parseInt(temps[0]), Integer.parseInt(temps[1]));
            r1 = Integer.parseInt(temps[2]);
            p2 = new Point(Integer.parseInt(temps[3]), Integer.parseInt(temps[4]));
            r2 = Integer.parseInt(temps[5]);
            if ((Integer.parseInt(temps[0]) == Integer.parseInt(temps[3])) && (Integer.parseInt(temps[1]) == Integer.parseInt(temps[4]) && (Integer.parseInt(temps[2]) == Integer.parseInt(temps[5])))) {
                ans = -1;
            } else {
                //두 점 사이 거리
                d = Math.sqrt(Math.abs(p1.x - p2.x) * Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) * Math.abs(p1.y - p2.y));
                if (d > r1 + r2) {
                    //원이 겹치는 곳이 없을 때
                } else if (d == r1 + r2) { //외접
                    ans = 1;
                } else {
                    int min = Math.min(r2, r1);
                    int max = Math.max(r2, r1);
                    if (d + min == max) { //내접
                        ans = 1;
                    } else if (d + min < max) { //원 안에 원
                        ans = 0;
                    } else { //두 곳에서 겹치는 경우
                        ans = 2;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
