import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.MAX_VALUE;
        int a = 0;
        int b = 0;

        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        for (int n = 0; n < N - 1 ; n++) {
            int left = n + 1;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                long abs = Math.abs(nums[n] + nums[mid]);

                if (abs < min) {
                    a = nums[n];
                    b = nums[mid];
                    min = abs;
                }

                abs = Math.abs(nums[n] + nums[left]);

                if (abs < min) {
                    a = nums[n];
                    b = nums[left];
                    min = abs;
                }

                abs = Math.abs(nums[n] + nums[right]);

                if (abs < min) {
                    a = nums[n];
                    b = nums[right];
                    min = abs;
                }

                if (nums[mid] < (nums[n] * -1)) { // ... mid ... n
                    left = mid + 1;
                } else if (nums[mid] == (nums[n] * -1)) { // ... mid ...
                    break; // 찾았다 0이 되는 용액
                } else { // ... n ... mid
                    right = mid - 1;
                }
            }

            if (min == 0) break;
        }

        System.out.println(a + " " + b);
    }
}

