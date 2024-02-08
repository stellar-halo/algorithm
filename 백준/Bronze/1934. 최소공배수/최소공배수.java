import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int temp = 0; temp < testCase; temp++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            ArrayList<Integer> aMeasures = new ArrayList<>();
            ArrayList<Integer> bMeasures = new ArrayList<>();
            getMeasures(a, aMeasures);
            getMeasures(b, bMeasures);

            int leastCommonMultiple = a;
            for (int t : aMeasures) {
                bMeasures.remove(Integer.valueOf(t));
            }
            for (int t : bMeasures) {
                leastCommonMultiple *= t;
            }
            bw.write(leastCommonMultiple + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void getMeasures(int n, ArrayList<Integer> arrayList) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                arrayList.add(i);
                getMeasures(n / i, arrayList);
                return;
            }
        }
    }
}
