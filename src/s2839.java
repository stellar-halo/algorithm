import java.util.Scanner;

public class s2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b;

        n = sc.nextInt();
        a = n / 5;
        b = n % 5;
        if (b == 0) System.out.println(a); //1. 5로 나눠질 경우, 가장 최소인 경우이므로 바로 출력
        else { //5의 배수가 아닌 경우
            if (b % 3 == 0) System.out.println(a + b / 3); //2. 나머지가 3의 배수인 경우, 바로 출력
            else { //나머지가 3의 배수가 아닌 경우
                if (a != 0 && (b + 5) % 3 == 0)
                    System.out.println(a - 1 + (b + 5) / 3);//2. a가 0이 아니면서 5를 하나 뺐을 때 3의 배수일 때
                else if (a >= 2 && (b + 10) % 3 == 0)
                    System.out.println(a - 2 + (b + 10) / 3); //2. a가 2이상이면서 10를 뺐을 때 3의 배수일 때
                else {
                    if (n % 3 == 0) System.out.println(n / 3); //3. 3의 배수인 경우
                    else System.out.println(-1); //그 어느 것으로도 나누어지지 않는 경우
                }
            }
        }
    }
}
