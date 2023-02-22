import java.io.*;
import java.util.Stack;

public class s10828 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int idx = 0; idx < n; idx++) {
            String order = bf.readLine();
            switch (order.substring(0, 2)) {
                case "pu":
                    String[] splitStr = order.split(" ");
                    stack.push(Integer.parseInt(splitStr[1]));
                    break;
                case "po":
                    if (stack.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(stack.pop() + "\n");
                    break;
                case "to":
                    if (stack.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(stack.peek() + "\n");
                    break;
                case "si":
                    bw.write(stack.size() + "\n");
                    break;
                case "em":
                    if (stack.isEmpty()) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        bf.close();
    }
}
