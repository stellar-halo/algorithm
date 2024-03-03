import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int a;
    static int count;
    static long max;
    static long min;
    static boolean[] visited;
    static String[] inputs;
    static String[] operatorCount;
    static String[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        a = Integer.parseInt(br.readLine());
        inputs = br.readLine().split(" ");
        operatorCount = br.readLine().split(" ");

        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        count = a - 1;
        visited = new boolean[count];
        operators = new String[count];

        int tmp = 0;
        for (int temp = 0; temp < 4; temp++) {
            int op = Integer.parseInt(operatorCount[temp]);
            while (op != 0) {
                if (temp == 0) operators[tmp] = "+";
                else if (temp == 1) operators[tmp] = "-";
                else if (temp == 2) operators[tmp] = "*";
                else operators[tmp] = "/";
                op--;
                tmp++;
            }
        }
        backTracking(1, Long.parseLong(inputs[0]));
        bw.write(max + "\n");
        bw.write(min + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int length, long s) {

        if (length == a) {
            if (s > max) max = s;
            if (s < min) min = s;
            return;
        }

        for (int temp = 0; temp < a - 1; temp++) {
            if (visited[temp]) continue;

            long currentNumber = Long.parseLong(inputs[length]);
            long tempS = s; // 현재 값을 임시로 저장

            if (operators[temp].equals("+")) {
                s += currentNumber;
            } else if (operators[temp].equals("-")) {
                s -= currentNumber;
            } else if (operators[temp].equals("*")) {
                s *= currentNumber;
            } else if (operators[temp].equals("/")) {
                s /= currentNumber;
            }

            visited[temp] = true;
            backTracking(length + 1, s);

            // 재귀 호출 이후 현재 값을 이전 값으로 되돌림
            s = tempS;
            visited[temp] = false;
        }
    }
}
