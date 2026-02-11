import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<int[]>[] graph; // graph[u] = {v, weight}
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[A].add(new int[]{B, W});
            graph[B].add(new int[]{A, W});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    static int dijkstra(int start, int end) {

        // dist[i] = start → i 까지의 최대 bottleneck 값
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        // 큰 weight가 먼저 나오도록 (최대 힙)
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // 시작점은 무한대처럼 시작 (제약 없음)
        pq.offer(new int[]{start, Integer.MAX_VALUE});
        dist[start] = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int weight = now[1];

            // 오래된 상태 제거
            if (weight < dist[node]) continue;

            // 목적지 도달 시 바로 반환 가능 (최적 보장)
            if (node == end) return weight;

            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int edgeWeight = next[1];

                // 현재 경로의 bottleneck 계산
                int newValue = Math.min(weight, edgeWeight);

                // 더 좋은 값이면 갱신
                if (newValue > dist[nextNode]) {
                    dist[nextNode] = newValue;
                    pq.offer(new int[]{nextNode, newValue});
                }
            }
        }

        return -1; // 도달 불가
    }
}
