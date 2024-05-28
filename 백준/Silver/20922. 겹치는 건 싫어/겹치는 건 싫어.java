import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 1;
        int left = 0;
        int right = 0;
        //HashMap을 쓰지 않고 int[] cnt = new int[100001];의 형식으로 써도 괜찮지만,
        //만일 수가 큰 경우의 문제라면, 해쉬맵을 쓰는 것이 훨 이득일 것
        Map<Integer, Integer> map = new HashMap<>();

        while (right < N) {
            //K를 넘지 않았다면, right를 증가시켜 준다.
            if (map.getOrDefault(A[right], 0) + 1 <= K) {
                map.put(A[right], map.getOrDefault(A[right], 0) + 1);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } 
            // K를 넘은 순간, right는 문제의 index에 고정이 되고 그렇게 되면 문제의 index가 해결될 때까지 left를 이동시켜주자.
            else {
                map.put(A[left], map.get(A[left]) - 1);
                left++;
            }
        }
        System.out.println(maxLength);
    }
}