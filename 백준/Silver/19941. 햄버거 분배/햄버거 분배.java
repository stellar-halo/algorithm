import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static private int n, k, maximumHamburgers;
    static private String[] ladder;
    static private boolean[] eatable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ladder = br.readLine().split("");
        eatable = new boolean[n];

        for (int idx = 0; idx < n; idx++) {
            if (Objects.equals(ladder[idx], "H")) eatable[idx] = true;
        }

        for (int idx = 0; idx < n; idx++) {
            boolean eat = false;
            int index = k;
            if (ladder[idx].equals("P")) {
                if (index > idx) index = idx;
                if (eatable[idx - index]) {
                    maximumHamburgers++;
                    eatable[idx - index] = false;
                    eat = true;
                } else {
                    while (index > 0) {
                        index = index - 1;
                        if (eatable[idx - index]) {
                            maximumHamburgers++;
                            eatable[idx - index] = false;
                            eat = true;
                            break;
                        }
                    }
                }

                if (!eat) {
                    int i = 0;
                    while (i < k && i + idx < n - 1) {
                        i = i + 1;
                        if (eatable[idx + i]) {
                            maximumHamburgers++;
                            eatable[idx + i] = false;
                            break;
                        }

                    }
                }
            }
        }

        System.out.println(maximumHamburgers);
    }
}
