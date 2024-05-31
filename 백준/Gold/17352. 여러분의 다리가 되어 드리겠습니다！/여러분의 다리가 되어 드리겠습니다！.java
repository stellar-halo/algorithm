import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static private int n, e, a, b, start;
    static private boolean[] visited;
    static private List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        e = n - 2;  // 연결된 섬들의 개수는 n - 2
        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // e개의 간선을 입력 받음
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            if (i == 0) start = to;
            int from = Integer.parseInt(st.nextToken());

            graph.get(to).add(from);
            graph.get(from).add(to); // 무향 그래프이므로 양쪽으로 간선 추가
        }

        if (n == 2) {
            a = 1;
            b = 2;
        } else {
            // 첫 번째 섬에서 DFS를 시작하여 연결된 모든 섬을 방문 처리
            dfs();
            // 방문하지 않은 두 섬을 찾음
            for (int i = 1; i <= n; i++) {
                if (a == 0 && visited[i]) a = i;
                if (b == 0 && !visited[i]) b = i;
                if (a != 0 && b != 0) break;
            }
        }

        System.out.println(a + " " + b);
    }

    static private void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}
