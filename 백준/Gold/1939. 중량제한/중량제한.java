import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int MIN = -1;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int n = 0; n <= N; n++) {
            graph[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, W));
            graph[B].add(new Node(A, W));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
    }

    static void dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MIN);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, MIN));
        dist[start] = MIN;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.weight < dist[now.node]) continue;
            
            for (Node next : graph[now.node]) {
                int l;
                if (dist[now.node] == MIN) {
                    l = next.weight;
                } else l = Math.min(dist[now.node], next.weight);

                if (dist[next.node] < l) {
                    pq.add(new Node(next.node, l));
                    dist[next.node] = l;
                }

            }
        }

        System.out.println(dist[end]);
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
            return Integer.compare(o.weight, this.weight);
        }
    }
}