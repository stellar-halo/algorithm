package bronze1085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x,y,w,h,min;
        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();

        min = (x<y) ? x : y ;
        min = (min < w-x)? min : w-x ;
        min = (min < h-y)? min : h-y ;
        System.out.println(min);
    }
}