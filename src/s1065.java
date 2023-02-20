import java.util.Scanner;

public class s1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 99;
        if (n < 100) System.out.println(n);
        else {
            for (int idx = 1; idx <= (n / 100); idx++) {
                if (idx * 100 + idx * 10 + idx <= n) m++;
                for (int i = 1; i < 5; i++) {
                    if (idx + i * 2 < 10) {
                        if (idx * 100 + (idx + i) * 10 + (idx + i * 2) <= n) m++;
                    }
                    if (idx - i * 2 >= 0) {
                        if (idx * 100 + (idx - i) * 10 + (idx - i * 2) <= n) m++;
                    }
                }
            }
            System.out.println(m);
        }
    }
}
