import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int last = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while(!queue.isEmpty()){
            if(!stack.isEmpty()){
                int q = queue.peek();
                int s = stack.peek();

                if (q == s) {
                    queue.poll();
                    stack.pop();
                    sb.append("-\n");
                } else if (s < q) {
                    stack.add(last);
                    last++;
                    sb.append("+\n");
                }else{
                    System.out.println("NO");
                    return;
                }
            }else{
                sb.append("+\n");
                stack.add(last);
                last++;
            }
        }

        System.out.println(sb);

    }
}
