import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int vertex, edge, count;
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] affectedCom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        affectedCom = new boolean[vertex + 1];
        affectedCom[1] = true;
        count = 0;
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int nextComputer : graph.get(idx)) {
                if (!affectedCom[nextComputer]) {
                    affectedCom[nextComputer] = true;
                    count++;
                    q.add(nextComputer);
                }
            }
        }

        System.out.println(count);
    }
}
