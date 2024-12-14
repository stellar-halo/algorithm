import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
가장 큰 수를 순서대로 뽑아도 성립하는가?
어짜피 a + b + c + d - 3 - 2 - 1 = ?
따라서 그냥 큰 수부터 순서대로 뽑은 뒤에 N-1 + N-2 + ... + 1까지 하면 될 듯
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int ans = 0;

        String[] nums = br.readLine().split(" ");
        Integer[] numbs = new Integer[n];

        for (int i = 0; i < n; i++) {
            numbs[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(numbs, Comparator.reverseOrder());

        for (int idx = 0; idx < k; idx++) {
            ans += numbs[idx];
            ans -= idx;
        }

        System.out.println(ans);
    }
}
