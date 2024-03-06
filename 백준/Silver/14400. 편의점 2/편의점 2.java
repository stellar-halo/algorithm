import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] customersX = new int[n];
        int[] customersY = new int[n];

        for (int temp = 0; temp < n; temp++) {
            String[] xy = br.readLine().split(" ");
            customersX[temp] = Integer.parseInt(xy[0]);
            customersY[temp] = Integer.parseInt(xy[1]);
        }

        Arrays.sort(customersX);
        Arrays.sort(customersY);

        int medianX = customersX[n / 2];
        int medianY = customersY[n / 2];

        long minXDistance = 0;
        long minYDistance = 0;

        for (int i = 0; i < n; i++) {
            minXDistance += Math.abs(medianX - customersX[i]);
            minYDistance += Math.abs(medianY - customersY[i]);
        }

        System.out.print(minXDistance + minYDistance);
        br.close();
    }
}
