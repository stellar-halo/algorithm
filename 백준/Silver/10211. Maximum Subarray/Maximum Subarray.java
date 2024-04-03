import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t, n, maximumSubarray;
    static int[] x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        //테케 여러개 검증 이 안에서 로직 구현할 것
        for (int temp = 0; temp < t; temp++) {
            //각 테케 별로 입력 받기 완
            n = Integer.parseInt(br.readLine());
            x = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int tmp = 0; tmp < n; tmp++) {
                x[tmp] = Integer.parseInt(st.nextToken());
                if (tmp == 0) maximumSubarray = x[tmp];
            }

            //끝까지 입력한 것 + 새로운 입력 vs 기존 리스트에서 가장 maximum
            dp();
            System.out.println(maximumSubarray);
        }
    }

    private static void dp() {
        int sum = 0;
        for (int i : x) {
            sum = Math.max(sum + i,i);
            maximumSubarray = Math.max(sum, maximumSubarray);
        }
    }
}
