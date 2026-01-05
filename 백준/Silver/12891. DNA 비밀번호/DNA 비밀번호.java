import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 0;
        int k = 0;
        int ans = 0;
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);

        String[] strings = br.readLine().split("");
        //{‘A’, ‘C’, ‘G’, ‘T’}
        String[] temps = br.readLine().split(" ");

        int[] checks = new int[4];
        for (int i = 0; i < k; i++) {
            if (strings[i].equals("A")) {
                checks[0]++;
            } else if (strings[i].equals("C")) {
                checks[1]++;
            } else if (strings[i].equals("G")) {
                checks[2]++;
            } else {
                checks[3]++;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (checks[i] >= Integer.parseInt(temps[i])) {
                if (i == 3) ans++;
            } else {
                break;
            }
        }

        for (int i = 0; i < n - k; i++) {
            if (strings[i].equals("A")) {
                checks[0]--;
            } else if (strings[i].equals("C")) {
                checks[1]--;
            } else if (strings[i].equals("G")) {
                checks[2]--;
            } else if (strings[i].equals("T")) {
                checks[3]--;
            }

            if (strings[i + k].equals("A")) {
                checks[0]++;
            } else if (strings[i + k].equals("C")) {
                checks[1]++;
            } else if (strings[i + k].equals("G")) {
                checks[2]++;
            } else if (strings[i + k].equals("T")) {
                checks[3]++;
            }

            for (int j = 0; j < 4; j++) {
                if (checks[j] >= Integer.parseInt(temps[j])) {
                    if (j == 3) ans++;
                } else {
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}