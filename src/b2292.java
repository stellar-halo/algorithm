import java.util.Scanner;

public class b2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //6의 배수로 점차 커진다 6,12,18 6안이면 2개 12 안이면 3개 이런식이다
        int idx = 0;
        int n = sc.nextInt();
        while (n > idx * 6 + 1) {
            n -= idx * 6;
            idx++;
        }
        System.out.println(idx+1);
    }
}
