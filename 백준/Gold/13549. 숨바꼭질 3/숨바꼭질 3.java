import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static int subin, sister;
    private static boolean[] visited;

    private static class Position {
        int x, time;

        Position(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        Deque<Position> deque = new LinkedList<>();
        deque.add(new Position(subin, 0));

        while (!deque.isEmpty()) {
            Position now = deque.poll();

            if (visited[now.x]) continue;
            visited[now.x] = true;

            if (now.x == sister) {
                System.out.println(now.time);
                return;
            }

            if (now.x * 2 <= 100000 && !visited[now.x * 2]) {
                deque.addFirst(new Position(now.x * 2, now.time));
            }
            if (now.x + 1 <= 100000 && !visited[now.x + 1]) {
                deque.addLast(new Position(now.x + 1, now.time + 1));
            }
            if (now.x - 1 >= 0 && !visited[now.x - 1]) {
                deque.addLast(new Position(now.x - 1, now.time + 1));
            }
        }
    }
}
