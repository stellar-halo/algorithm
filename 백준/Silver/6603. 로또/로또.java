import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static int K;

    public static void main(String[] args) throws Exception {
        K = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st;
        while (K != 0) {
            st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;
            nums = new int[K];
            for (int k = 0; k < K; k++) {
                nums[k] = Integer.parseInt(st.nextToken());
            }
            combination(0, 0, "");
            System.out.println();
        }
    }

    static void combination(int depth, int start, String ans) {
        if (depth == 6) {
            System.out.println(ans);
            return;
        }

        for (int i = start; i < K; i++) {
            combination(depth + 1, i + 1, ans + nums[i] + " ");
        }
    }
}