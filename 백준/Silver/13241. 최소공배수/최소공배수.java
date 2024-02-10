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

        String[] inputs = br.readLine().split(" ");

        long a = Long.parseLong(inputs[0]);
        long b = Long.parseLong(inputs[1]);
        ArrayList<Long> aMeasures = new ArrayList<>();
        getMeasures(a, aMeasures);

        for (long t : aMeasures) {
            if (b % t == 0) {
                b /= t;
            }
            if (b == 1) break;
        }

        long leastCommonMultiple = a * b;
        bw.write(leastCommonMultiple + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void getMeasures(long n, ArrayList<Long> arrayList) {
        for (long i = 2; i <= n; i++) {
            if (n % i == 0) {
                arrayList.add(i);
                getMeasures(n / i, arrayList);
                return;
            }
        }
    }
}
