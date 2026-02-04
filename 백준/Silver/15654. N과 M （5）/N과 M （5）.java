import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            getC(i, M, "", visited);
        }
    }

    static void getC(int i, int k, String list, boolean[] visited) {

        visited[i] = true;
        list = list + nums.get(i) + " ";
        k--;
        if (k == 0) {
            System.out.println(list);
        }
        for (int idx = 0; idx < nums.size(); idx++) {
            if (!visited[idx]) {
                getC(idx, k, list, visited);
                visited[idx] = false;
            }
        }

    }
}
