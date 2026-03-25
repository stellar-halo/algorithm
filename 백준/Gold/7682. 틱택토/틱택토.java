import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String[] board;

        HashSet<Integer> set1 = new HashSet<>();
        set1.add(0);
        set1.add(1);
        set1.add(2);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        HashSet<Integer> set3 = new HashSet<>();
        set3.add(6);
        set3.add(7);
        set3.add(8);
        HashSet<Integer> set4 = new HashSet<>();
        set4.add(0);
        set4.add(4);
        set4.add(8);
        HashSet<Integer> set5 = new HashSet<>();
        set5.add(2);
        set5.add(4);
        set5.add(6);
        HashSet<Integer> set6 = new HashSet<>();
        set6.add(0);
        set6.add(3);
        set6.add(6);
        HashSet<Integer> set7 = new HashSet<>();
        set7.add(2);
        set7.add(5);
        set7.add(8);
        HashSet<Integer> set8 = new HashSet<>();
        set8.add(1);
        set8.add(4);
        set8.add(7);

        while (!S.equals("end")) {
            board = S.split("");
            int X = 0;
            HashSet<Integer> xs = new HashSet<>();
            int O = 0;
            HashSet<Integer> os = new HashSet<>();

            int Xwinner = 0;
            int Owinner = 0;

            for (int idx = 0; idx < 9; idx++) {
                String b = board[idx];
                if (b.equals("X")) {
                    X++;
                    xs.add(idx);
                }
                if (b.equals("O")) {
                    O++;
                    os.add(idx);
                }
            }

            Xwinner = getWinner(set1, set2, set3, set4, set5, set6, set7, set8, xs);
            Owinner = getWinner(set1, set2, set3, set4, set5, set6, set7, set8, os);
            if (Xwinner > 0 && Owinner > 0) {
                System.out.println("invalid");
                S = br.readLine();
                continue;
            }
            if ((X - O == 1) && (Xwinner > 0)) { //X가 이겼을 때
                System.out.println("valid");
                S = br.readLine();
                continue;
            }
            if ((X == O) && (Owinner == 1)) { //O가 이겼을 때
                System.out.println("valid");
                S = br.readLine();
                continue;
            }
            if (X == 5 && O == 4 && Xwinner == 0 && Owinner == 0) { //무승부
                System.out.println("valid");
                S = br.readLine();
                continue;
            }

            System.out.println("invalid");
            S = br.readLine();
        }
    }

    private static int getWinner(HashSet<Integer> set1, HashSet<Integer> set2, HashSet<Integer> set3, HashSet<Integer> set4, HashSet<Integer> set5, HashSet<Integer> set6, HashSet<Integer> set7, HashSet<Integer> set8, HashSet<Integer> set) {
        int winner = 0;
        if (set.containsAll(set1)) winner++;
        if (set.containsAll(set2)) winner++;
        if (set.containsAll(set3)) winner++;
        if (set.containsAll(set4)) winner++;
        if (set.containsAll(set5)) winner++;
        if (set.containsAll(set6)) winner++;
        if (set.containsAll(set7)) winner++;
        if (set.containsAll(set8)) winner++;
        return winner;
    }
}

