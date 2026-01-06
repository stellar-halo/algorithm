import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int ROOT = 0;
    static int LEFT = 1;
    static int RIGHT = 2;

    public static void main(String[] args) throws IOException {
        String[][] tree = new String[26][3];
        int[] visited = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            int root = tmp[0].charAt(0) - 65;
            for (int j = 0; j < 3; j++) {
                tree[root][j] = tmp[j];
            }
        }

        //전위
        System.out.println(preorder("A", tree));
        //후위
        System.out.println(inorder("A", tree));
        //중위
        System.out.println(postorder("A", tree));

    }

    public static String preorder(String start, String[][] tree) {
        char root = start.charAt(0);
        int idx = (int) root - 65;
        String left = tree[idx][LEFT];
        String right = tree[idx][RIGHT];

        if (!left.equals(".")) {
            left = preorder(left, tree);
        }else{
            left = "";
        }
        if (!right.equals(".")) {
            right = preorder(right, tree);
        }else{
            right = "";
        }
        return start + left + right;
    }

    public static String inorder(String start, String[][] tree) {
        char root = start.charAt(0);
        int idx = (int) root - 65;
        String left = tree[idx][LEFT];
        String right = tree[idx][RIGHT];

        if (!left.equals(".")) {
            left = inorder(left, tree);
        }else{
            left = "";
        }
        if (!right.equals(".")) {
            right = inorder(right, tree);
        }else{
            right = "";
        }
        return left + start + right;
    }

    public static String postorder(String start, String[][] tree) {
        char root = start.charAt(0);
        int idx = (int) root - 65;
        String left = tree[idx][LEFT];
        String right = tree[idx][RIGHT];

        if (!left.equals(".")) {
            left = postorder(left, tree);
        }else{
            left = "";
        }
        if (!right.equals(".")) {
            right = postorder(right, tree);
        }else{
            right = "";
        }
        return left + right + start;
    }
}