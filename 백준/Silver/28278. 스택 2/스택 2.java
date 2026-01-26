import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1 < N < 10000
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            String f = st.nextToken();
            if (f.equals("1")) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (f.equals("2")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } else if (f.equals("3")) {
                System.out.println(stack.size());
            } else if (f.equals("4")) {
                if (stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }

            } else if (f.equals("5")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
