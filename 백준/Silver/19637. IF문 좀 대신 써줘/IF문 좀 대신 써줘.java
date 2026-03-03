import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] names = new String[N];
        int[] levels = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            levels[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            int left = 0, right = N - 1;

            while (left < right) {
                int mid = (left + right) / 2;
                
                if (levels[mid] >= power) right = mid;   // 같아도 왼쪽으로
                else left = mid + 1;
            }

            sb.append(names[left]).append('\n');
        }

        System.out.print(sb);
    }
}