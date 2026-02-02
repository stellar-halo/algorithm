import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rabbit = Integer.parseInt(br.readLine());

        while (rabbit != 0) {
            StringBuilder sb = new StringBuilder();
            int right = 50;
            int left = 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                sb.append(mid);

                if (mid > rabbit) {
                    right = mid - 1;
                } else if (mid < rabbit) {
                    left = mid + 1;
                } else {
                    break;
                }
                sb.append(" ");
            }
            System.out.println(sb);
            rabbit = Integer.parseInt(br.readLine());
        }

    }
}
