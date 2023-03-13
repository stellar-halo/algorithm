package b1259;

import java.io.*;

public class Main {

    static Boolean isPalindrome = true;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            isPalindrome = true;
            String p = br.readLine();
            if (p.equals("0")) break;
            else {
                palindrome(p, 0, p.length() - 1);
                if (isPalindrome) bw.write("yes\n");
                else bw.write("no\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void palindrome(String p, int start, int end) {
        if (start <= end) {
            if (p.charAt(start) == p.charAt(end)) {
                palindrome(p, start + 1, end - 1);
            } else {
                isPalindrome = false;
            }
        }
    }
}
