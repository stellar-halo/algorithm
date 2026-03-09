import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] series = new int[3001];
        int[] rail = new int[N + k];
        HashSet<Integer> kinds = new HashSet<>();
        kinds.add(c);
        int max = 1;

        for (int n = 0; n < N + k; n++) {
            int sushi;

            if (n < k) {
                sushi = Integer.parseInt(br.readLine());
                rail[n] = sushi; //레일 기록

                series[sushi]++;
                kinds.add(sushi);
                max = Math.max(max, kinds.size());
            } else if (n >= N) {
                rail[n] = rail[n - N]; //레일 기록
                int prev = rail[n - k]; //이전 초밥

                series[prev]--;
                if (series[prev] == 0 && prev != c) { //초밥 종류가 떨어졌다면
                    kinds.remove(prev); //제거
                }

                series[rail[n]]++;
                kinds.add(rail[n]);
                max = Math.max(max, kinds.size());
            } else {
                sushi = Integer.parseInt(br.readLine());
                rail[n] = sushi; //레일 기록
                int prev = rail[n - k]; //이전 초밥

                series[prev]--;
                if (series[prev] == 0 && prev != c) { //초밥 종류가 떨어졌다면
                    kinds.remove(prev); //제거
                }

                series[sushi]++;
                kinds.add(sushi);
                max = Math.max(max, kinds.size());
            }
        }

        System.out.println(max);
    }
}