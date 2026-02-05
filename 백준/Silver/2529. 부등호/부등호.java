import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static boolean[] used;
    static String[] inequalities;
    static int K;
    static String max;
    static String min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        inequalities = new String[K];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int k = 0; k < K; k++) {
            inequalities[k] = st.nextToken();
        }

        max = "";
        used = new boolean[10];
        getMax(K + 1, "", "");
        System.out.println(max);

        min = "";
        used = new boolean[10];
        getMin(K + 1, "", "");
        System.out.println(min);
    }

    static void getMax(int d, String s, String ans) {
        if (d == 0) {
            max = ans;
        } else {
            if (Objects.equals(ans, "")) { // 첫 숫자일 때
                for (int i = 9; i >= 0; i--) {
                    used[i] = true;
                    getMax(d - 1, i + "", i + "");
                    if (!max.isEmpty()) return;
                    used[i] = false;
                }
            } else {
                int diff = K - d;
                int t = Integer.parseInt(s);
                if (inequalities[diff].equals("<")) { // ex) 3 < 5
                    for (int i = 9; i > t; i--) {
                        if (!used[i]) {
                            used[i] = true;
                            getMax(d - 1, i + "", ans + i);
                            used[i] = false;
                        }
                        if (!max.isEmpty()) return;
                    }
                } else { // ex) 5 > 4
                    for (int i = t - 1; i >= 0; i--) {
                        if (!used[i]) {
                            used[i] = true;
                            getMax(d - 1, i + "", ans + i);
                            used[i] = false;
                        }
                        if (!max.isEmpty()) return;
                    }
                }
            }
        }
    }

    static void getMin(int d, String s, String ans) {
        if (d == 0) {
            min = ans;
        } else {
            if (Objects.equals(ans, "")) { // 첫 숫자일 때
                for (int i = 0; i <= 9; i++) {
                    used[i] = true;
                    getMin(d - 1, i + "", i + "");
                    if (!min.isEmpty()) return;
                    used[i] = false;
                }
            } else {
                int diff = K - d;
                int t = Integer.parseInt(s); // 이전 숫자
                if (inequalities[diff].equals("<")) { // ex) 3 < 5
                    for (int i = t + 1; i <= 9; i++) {
                        if (!used[i]) {
                            used[i] = true;
                            getMin(d - 1, i + "", ans + i);
                            used[i] = false;
                        }
                        if (!min.isEmpty()) return;
                    }
                } else { // ex) 5 > 4
                    for (int i = 0; i < t; i++) {
                        if (!used[i]) {
                            used[i] = true;
                            getMin(d - 1, i + "", ans + i);
                            used[i] = false;
                        }
                        if (!min.isEmpty()) return;
                    }
                }
            }
        }
    }
}
