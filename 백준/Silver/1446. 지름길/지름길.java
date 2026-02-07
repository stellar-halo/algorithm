import java.io.*;
import java.util.*;

public class Main {

    // 지름길 정보 저장용 클래스
    static class Shortcut {
        int start;  // 시작 위치
        int end;    // 도착 위치
        int cost;   // 지름길 길이

        Shortcut(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길 개수
        int D = Integer.parseInt(st.nextToken()); // 고속도로 길이

        // 지름길들 저장
        ArrayList<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 도착 지점이 D를 넘는 지름길은 의미 없음
            if (e <= D) {
                shortcuts.add(new Shortcut(s, e, c));
            }
        }

        // dist[i] = 0에서 i까지 가는 "현재까지 알려진" 최소 거리
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // 시작점

        // 우선순위큐: (현재 위치, 현재까지 거리)
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{0, 0}); // 시작 위치 0, 거리 0

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];   // 현재 위치
            int cost = cur[1];  // 그 위치까지의 비용

            // 이미 더 짧은 경로로 온 적 있으면 무시
            if (cost > dist[pos]) continue;

            // 1️⃣ 그냥 도로로 1km 이동
            if (pos + 1 <= D) {
                if (dist[pos + 1] > cost + 1) {
                    dist[pos + 1] = cost + 1;
                    pq.offer(new int[]{pos + 1, dist[pos + 1]});
                }
            }

            // 2️⃣ 현재 위치에서 시작하는 지름길들 확인
            for (Shortcut sc : shortcuts) {
                if (sc.start == pos) {
                    if (dist[sc.end] > cost + sc.cost) {
                        dist[sc.end] = cost + sc.cost;
                        pq.offer(new int[]{sc.end, dist[sc.end]});
                    }
                }
            }
        }

        // 목적지 D까지의 최소 거리
        System.out.println(dist[D]);
    }
}
