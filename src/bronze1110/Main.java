package bronze1110;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, idx, tmp;

        n = sc.nextInt();
        tmp = n;
        idx = 0;
        do{
            tmp = tmp%10*10 + (tmp/10+tmp%10)%10;
            idx++;
        }while(tmp != n);
        System.out.println(idx);
    }
}
