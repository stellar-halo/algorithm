import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        HashSet<String> players = new HashSet<>();

        for (int n = 0; n < N; n++) {
            String name = br.readLine();
            players.add(name);
        }

        int num = 0;
        if(game.equals("Y")) num = 1;
        if(game.equals("F")) num = 2;
        if(game.equals("O")) num = 3;

        System.out.println(players.size() / num);
    }
}
