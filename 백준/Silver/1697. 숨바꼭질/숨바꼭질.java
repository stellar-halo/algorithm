import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Spot {
        private int locate;
        private int count;

        Spot(int locate, int count) {
            this.locate = locate;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        Boolean[] visited = new Boolean[100001];
        Arrays.fill(visited, false);

        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Spot current = q.poll();
            int locate = current.locate;
            int count = current.count;
            if (locate == k) { //지금 위치가 동생이 있는 위치
                bw.write(count + "");
                break;
            }
            //다음 이동이 동생이 있는 위치라면,,
            if (locate - 1 == k || locate + 1 == k || locate * 2 == k) {
                bw.write(count + 1 + "");
                break;
            }
            //다음 이동이 동생이 있지 않는 곳-1: x-1
            if (locate - 1 >= 0 && !visited[locate - 1]) {
                q.add(new Spot(locate - 1, count + 1));
                visited[locate - 1] = true;
            }
            //다음 이동이 동생이 있지 않는 곳-1: x+1
            if (locate + 1 >= 0 && locate + 1 <= 100000 && !visited[locate + 1]) {
                q.add(new Spot(locate + 1, count + 1));
                visited[locate + 1] = true;
            }
            //다음 이동이 동생이 있지 않는 곳-1: x*2
            if (locate * 2 >= 0 && locate * 2 <= 100000 && !visited[locate * 2]) {
                q.add(new Spot(locate * 2, count + 1));
                visited[locate * 2] = true;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
