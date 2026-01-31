import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");
        int[] A = new int[N];
        int[] B = new int[N];

        for (int s = 0; s < N; s++) {
            A[s] = Integer.parseInt(a[s]);
            B[s] = Integer.parseInt(b[s]);
        }

        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int s = 0; s < N; s++) {
            sum += A[s] * B[B.length - s - 1];
        }

        System.out.println(sum);
    }
}
