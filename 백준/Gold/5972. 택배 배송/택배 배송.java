import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static ArrayList<ArrayList<Node>> graph;
    private static boolean[] visited;
    private static int[] cost;

    private static class Node implements Comparable<Node> {
        int idx, w;

        Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        cost = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= n; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        cost[1] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight)); // 양방향 그래프이기 때문에 필요한 구간이다!!!
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentIdx = currentNode.idx;

            //우선순위큐를 사용했기 때문에 방문했으면 넘어가도 된다.
            if (visited[currentIdx]) continue;

            visited[currentIdx] = true;

            for (Node neighbor : graph.get(currentIdx)) {
                if (cost[neighbor.idx] > cost[currentIdx] + neighbor.w) {
                    cost[neighbor.idx] = cost[currentIdx] + neighbor.w;
                    pq.offer(new Node(neighbor.idx, cost[neighbor.idx]));
                }
            }
        }

        System.out.println(cost[n]);
    }
}
