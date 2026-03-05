import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        ArrayList<String> eliminated = new ArrayList<>();
        Queue<String> eliminating = new LinkedList<>();
        eliminating.add(T);
        while (!eliminating.isEmpty()) {
            String s = eliminating.poll();
            boolean isEliminated = true;
            if (s.isEmpty()) continue;
            if (s.length() == 1) eliminated.add(s);
            else {
                if (s.charAt(0) == 'B') {
                    String b = s.substring(1);
                    StringBuilder sb = new StringBuilder(b);
                    String reversedB = sb.reverse().toString();

                    if (reversedB.equals(S)) {
                        eliminated.clear();
                        eliminated.add(reversedB);
                        break;
                    } else {
                        eliminating.add(reversedB);
                    }

                    isEliminated = false;
                }

                if (s.charAt(s.length() - 1) == 'A') {
                    String a = s.substring(0, s.length() - 1);

                    if (a.equals(S)) {
                        eliminated.clear();
                        eliminated.add(a);
                        break;
                    } else {
                        eliminating.add(a);
                    }

                    isEliminated = false;
                }

                if (isEliminated) eliminated.add(s);
            }

        }

        if (eliminated.contains(S)) System.out.println("1");
        else System.out.println("0");

    }
}