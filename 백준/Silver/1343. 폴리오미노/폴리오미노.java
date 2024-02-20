import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String board = sc.next();
        sc.close();
        String result = "";
        result = poliomino(board);
        System.out.println(result);
    }

    private static String poliomino(String board) {
        String ans = "";
        String A = "AAAA", B = "BB";
        board = board.replaceAll("XXXX", A);
        ans = board.replaceAll("XX", B);
        if (ans.contains("X")) {
            ans = "-1";
        }
        return ans;
    }
}