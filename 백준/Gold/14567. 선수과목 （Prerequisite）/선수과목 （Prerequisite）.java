import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] inDegree, semester;
    private static ArrayList<Integer>[] graph;

    private static class Class {
        int subject, count;

        Class(int subject, int count) {
            this.subject = subject;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inDegree = new int[n + 1];
        semester = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            semester[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            inDegree[from]++;
            graph[to].add(from);
        }

        topological();
        for (int i = 1; i <= n; i++) {
            System.out.print(semester[i] + " ");
        }
    }

    private static void topological() {
        Queue<Class> q = new LinkedList<>();
        int classCount = 1;
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(new Class(i, 1));
                semester[i] = classCount;
            }
        }

        while (!q.isEmpty()) {
            Class now = q.poll();
            classCount = now.count + 1;
            ArrayList<Integer> classList = graph[now.subject];
            int len = classList.size();

            for (int temp = 0; temp < len; temp++) {
                int index = classList.get(temp);
                if (inDegree[index] > 0) {
                    inDegree[index]--;
                    if (inDegree[index] == 0) {
                        q.add(new Class(index, classCount));
                        if (semester[index] > classCount) semester[index] = classCount;
                    }
                }
            }
        }
    }
}
