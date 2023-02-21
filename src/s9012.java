import java.util.Scanner;

public class s9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int idx = 0; idx < n; idx++) {
            int m = 0;
            String ps = sc.nextLine();
            for (int i = 0; i < ps.length(); i++) {
                char bracket = ps.charAt(i);
                if (bracket == '(') m++;
                else if (bracket == ')') m--;

                if (m < 0) break;
            }
            if (m == 0) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}
