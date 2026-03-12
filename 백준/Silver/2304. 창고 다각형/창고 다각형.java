import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] walls = new int[1001];
        ArrayList<Integer> tallest = new ArrayList<>();
        int max = 0;

        StringTokenizer st;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            walls[L] = H;

            if (max < H) {
                max = H;

                tallest.clear();
                tallest.add(L);
            } else if (max == H) {
                tallest.add(L);
            }
        }

        int height = 0;
        int area = 0;
        Collections.sort(tallest);
        int asc = tallest.get(0);
        int desc = tallest.get(tallest.size() - 1);

        for (int idx = 0; idx < asc; idx++) {
            if (walls[idx] > height) height = walls[idx];
            area += height;
        }

        for (int idx = asc; idx < desc + 1; idx++) {
            area += max;
        }

        height = 0;

        for (int idx = 1000; idx > desc; idx--) {
            if (walls[idx] > height) height = walls[idx];
            area += height;
        }

        System.out.println(area);
    }
}