import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int temp = 0; temp < n; temp++) {
            int number = Integer.parseInt(br.readLine());
            numbers.add(number);
            sum += number;
        }
        int arithmeticMean = (int) Math.round((double) sum / n);
        bw.write(arithmeticMean + "\n");

        Collections.sort(numbers);

        int median = numbers.get(n / 2);
        bw.write(median + "\n");

        int mode = 0;
        int maxContinuity = 0;
        int currentContinuity = 0;
        int max = 0;
        int pre = 0;
        for (int temp : numbers) {
            if (maxContinuity == 0) {
                pre = temp;
                mode = temp;
                maxContinuity++;
                currentContinuity++;
                max = 1;
            } else {
                if (pre == temp) {
                    currentContinuity++;
                } else {
                    currentContinuity = 1;
                }
                if (maxContinuity < currentContinuity) {
                    maxContinuity = currentContinuity;
                    mode = temp;
                    max = 1;
                } else if (maxContinuity == currentContinuity) {
                    max++;
                    if (max == 2) {
                        mode = temp;
                    }

                }
                pre = temp;
            }
        }
        bw.write( mode + "\n");

        int range = 0;
        int minimum = numbers.get(0);
        int maximum = numbers.get(n - 1);
        range = maximum - minimum;
        bw.write(range + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
