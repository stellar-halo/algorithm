import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graphs;
    static int N;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graphs = new ArrayList[N + 1];

        for (int n = 0; n <= N; n++) {
            graphs[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graphs[A].add(B);
        }
        dijkstra(X);

    }

    static void dijkstra(int x) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        while (!q.isEmpty()) {
            int now = q.poll();

            visited[now] = true;
            for (int next : graphs[now]) {
                if (!visited[next]) {
                    q.add(next);
                    dist[next] = dist[now] + 1;
                    visited[next] = true;
                    if (dist[next] == K) {
                        ans.add(next);
                    }
                }
            }
        }

        if (ans.isEmpty()) ans.add(-1);

        Collections.sort(ans);

        for (int a : ans) {
            System.out.println(a);
        }
    }
}
