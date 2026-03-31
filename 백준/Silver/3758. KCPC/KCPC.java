import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<Team> teams = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                teams.add(new Team(i + 1, 0, 0, 0, new HashMap<>()));
            }

            for (int idx = 0; idx < m; idx++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                teams.get(i - 1).cnt = teams.get(i - 1).cnt + 1;
                teams.get(i - 1).lastTime = idx;

                if (teams.get(i - 1).problems.containsKey(j)) {
                    if (teams.get(i - 1).problems.get(j) < s) {
                        teams.get(i - 1).sum = teams.get(i - 1).sum - teams.get(i - 1).problems.get(j) + s;
                        teams.get(i - 1).problems.replace(j, s);

                    }
                } else {
                    teams.get(i - 1).sum += s;
                    teams.get(i - 1).problems.put(j, s);
                }
            }

            PriorityQueue<Team> pq = new PriorityQueue<>((t1, t2) -> {
                if (t1.sum == t2.sum) {
                    if (t1.cnt == t2.cnt) {
                        return t1.lastTime - t2.lastTime;
                    } else {
                        return t1.cnt - t2.cnt;
                    }
                } else {
                    return t2.sum - t1.sum;
                }
            });

            pq.addAll(teams);

            int rank = 1;

            while (!pq.isEmpty()) {
                Team ts = pq.poll();
                if (ts.idx == t) break;
                rank++;
            }

            System.out.println(rank);
        }
    }

    static class Team {
        int idx, lastTime, cnt, sum;
        HashMap<Integer, Integer> problems;

        Team(int idx, int lastTime, int cnt, int sum, HashMap<Integer, Integer> problems) {
            this.idx = idx;
            this.lastTime = lastTime;
            this.cnt = cnt;
            this.sum = sum;
            this.problems = problems;
        }
    }
}

