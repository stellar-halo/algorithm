package bronze1009;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, a, b, x, r;

        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            a = sc.nextInt();
            a = (a > 10) ? a % 10 : a;
            b = sc.nextInt();
            x = 1;
            r = 1;
            switch ((a > 5) ? a - 5 : a) {
                case 0:
                case 1:
                    break;
                case 2:
                case 3:
                    r = (b % 4 == 0) ? 4 : b % 4;
                    break;
                case 4:
                    r = (b % 2 == 0) ? 2 : b % 2;
                    break;
            }
            for (int idx = 0; idx < r; idx++) {
                x = (x * a) % 10;
            }
            x = (x == 0) ? 10 : x;
            System.out.println(x);
        }
    }
}
