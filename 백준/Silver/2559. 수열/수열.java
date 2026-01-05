import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException {
        int tmp = 0;
        int max = 0;
        int n = 0;
        int k = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);

        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            tmp += Integer.parseInt(nums[i]);
        }
        max = tmp;

        for (int i = 0; i < n - k; i++) {
            tmp = tmp - Integer.parseInt(nums[i]) + Integer.parseInt(nums[i + k]);
            max = Math.max(tmp, max);
        }

        System.out.println(max);
    }
}