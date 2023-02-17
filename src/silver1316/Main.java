package silver1316;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Character> set = new HashSet<Character>();

        int n = sc.nextInt();
        sc.nextLine();
        int answer = 0;
        for (int idx = 0; idx < n; idx++) {
            set.clear();
            Boolean bool = true;
            String str = sc.nextLine();
            for (int i = 0; i < str.length(); i++) {
                if(! set.add(str.charAt(i))){
                    bool = (str.charAt(i) != str.charAt(i-1))? false: bool;
                }
            }
            if(bool) answer++;
        }
        System.out.println(answer);
    }
}
