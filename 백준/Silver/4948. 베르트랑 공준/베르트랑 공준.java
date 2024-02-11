import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static boolean[] prime = new boolean[246913];
    public static int[] countPrimes = new int[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        getPrimes();
        getCountPrimes();

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            bw.write((countPrimes[2 * num] - countPrimes[num]) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void getPrimes() {
        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) continue;
            prime[i] = isPrime(i);
        }
    }

    public static boolean isPrime(int number) {
        if(number<2) return true;
        if (number == 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }

    public static void getCountPrimes() {
        int count = 0;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) count++;
            countPrimes[i] = count;
        }
    }
}
