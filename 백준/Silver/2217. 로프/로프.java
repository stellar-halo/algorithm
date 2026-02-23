import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(br.readLine());

            nums.add(num);
        }

        Collections.sort(nums);
        int max = 0;
        for (int idx = 0; idx < N; idx++) {
            max = Math.max(max, nums.get(idx) * (nums.size() - idx));

        }

        System.out.println(max);
    }
}