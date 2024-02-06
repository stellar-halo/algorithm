import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] selfNumbersArray = new boolean[10001];
        Arrays.fill(selfNumbersArray, true);
        for (int i = 1; i < 9983; i++) {
            int x = d(i);
            while (x <= 10000) {
                if (selfNumbersArray[x]) {
                    selfNumbersArray[x] = false;
                    x = d(x);
                } else break;
            }
        }
        for (int i = 1; i <= 10000; i++) {
            if (selfNumbersArray[i]) bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int d(int n) {
        int length = (int) (Math.log10(n) + 1);
        int sum = n;
        for (int temp = 0; temp < length; temp++) {
            int digit = (int) (n / Math.pow(10, (length - temp - 1)));
            sum += digit;
            n = (int) (n % Math.pow(10, (length - temp - 1)));
        }
        return sum;
    }
}
