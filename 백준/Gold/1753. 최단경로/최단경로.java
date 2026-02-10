import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];

        for (int v = 0; v <= V; v++) {
            graph[v] = new ArrayList<>();
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, W));
        }

        dijkstra(K);
    }

    static void dijkstra(int k) {
        int MAX = 1000000;
        int[] dist = new int[V + 1];
        Arrays.fill(dist, MAX);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node next : graph[now.node]) {
                int w = now.weight + next.weight;
                if (w < dist[next.node]) {
                    dist[next.node] = w;
                    pq.add(new Node(next.node, w));
                }
            }

        }

        for (int idx = 1; idx <= V; idx++) {
            int d = dist[idx];
            if (d == MAX) {
                System.out.println("INF");
            } else {
                System.out.println(d);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node, weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
