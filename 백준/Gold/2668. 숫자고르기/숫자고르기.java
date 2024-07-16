import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] table;
    private static HashSet<Integer> cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        table = new int[num + 1];
        cycle = new HashSet<>();

        for (int idx = 1; idx <= num; idx++) {
            table[idx] = Integer.parseInt(br.readLine());
        }

        for (int idx = 1; idx <= num; idx++) {
            findCycle(idx);
        }
        ArrayList<Integer> sortedCycleList = new ArrayList<>(cycle);
        Collections.sort(sortedCycleList);

        System.out.println(sortedCycleList.size());
        for (int s : sortedCycleList) {
            System.out.println(s);
        }
    }

    private static void findCycle(int startIdx) {
        boolean[] visited = new boolean[table.length + 1];
        visited[startIdx] = true;

        ArrayList<Integer> cycleList = new ArrayList<>();
        cycleList.add(startIdx);
        Queue<Integer> q = new LinkedList<>();
        q.add(startIdx);

        while (!q.isEmpty()) {
            int now = q.poll();
            int next = table[now];

            if (startIdx == next) {
                cycle.addAll(cycleList);
                break;
            }
            if (visited[next]) break;

            q.add(next);
            cycleList.add(next);
            visited[next] = true;
        }
    }
}
