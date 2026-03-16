import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> nums = new PriorityQueue<>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (nums.size() >= N && nums.peek() < num) {
                    nums.poll();
                    nums.add(num);
                } else if (nums.size() < N) {
                    nums.add(num);
                }
            }
        }

        System.out.println(nums.peek());
    }
}
