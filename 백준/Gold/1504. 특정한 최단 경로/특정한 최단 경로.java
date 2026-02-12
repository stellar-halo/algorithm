import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int MAX = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int n = 0; n <= N; n++) {
            graph[n] = new ArrayList<>();
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, W));
            graph[B].add(new Node(A, W));
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());


        long a = dijkstra(1, A) + dijkstra(A, B) + dijkstra(B, N);
        long b = dijkstra(1, B) + dijkstra(B, A) + dijkstra(A, N);
        if (dijkstra(1, A) == -1 || dijkstra(A, B) == -1 || dijkstra(B, N) == -1) {
            a  = -1;
        }

        if (dijkstra(1, B) == -1 || dijkstra(B, A) == -1 || dijkstra(A, N) == -1) {
            b  = -1;
        }
        if (a == -1) {
            System.out.println(b);
        } else if (b == -1) {
            System.out.println(a);
        }else{
            System.out.println(Math.min(a,b));
        }
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.node] < now.weight) continue;

            for (Node next : graph[now.node]) {
                int w = dist[now.node] + next.weight;
                if (w < dist[next.node]) {
                    dist[next.node] = w;
                    pq.add(new Node(next.node, w));
                }
            }
        }
        return (dist[end] == MAX) ? -1 : dist[end];
    }

    static class Node implements Comparable<Node> {
        int node;
        int weight;

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