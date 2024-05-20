import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static private int n, k;
    static private boolean[] seated;
    static private ArrayList<Integer> josephusAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        seated = new boolean[n + 1];
        josephusAnswer = new ArrayList<>();
        josephus();
        System.out.print("<");
        for (int tmp = 0; tmp < n-1; tmp++) {
            System.out.print(josephusAnswer.get(tmp)+", ");
        }
        System.out.print(josephusAnswer.get(n - 1));
        System.out.print(">");
    }

    private static void josephus() {
        int idx = 0;
        int count = 0;
        while (josephusAnswer.size() != n) {
            if (idx > n) idx = idx % n;
            if(idx == 0) idx = 1;
            if(!seated[idx]){
               count++;
           }
            if(count == k){
                josephusAnswer.add(idx);
                seated[idx] = true;
                count = 0;
            }
            idx++;
        }

    }
}
