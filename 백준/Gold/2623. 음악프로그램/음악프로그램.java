import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;

    static private ArrayList<HashSet<Integer>> graph;
    static private ArrayList<Integer> answer;
    private static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        inDegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int num = Integer.parseInt(inputs[0]);
            for (int j = 1; j < num; j++) {
                int a = Integer.parseInt(inputs[j]);
                for (int k = j + 1; k <= num; k++) {
                    int b = Integer.parseInt(inputs[k]);
                    if(graph.get(a).add(b)) inDegree[b]++;
                }
            }
        }
        topologicalSort();
        if (answer.size() != n) bw.write(0 + "");
        else {
            for (int a : answer) {
                bw.write(a + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        answer = new ArrayList<>();

        // 진입차수가 0인 정점을 큐에 추가
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            answer.add(cur);

            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
