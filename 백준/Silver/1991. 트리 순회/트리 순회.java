import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] tree = new char[26][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int root = input[0].charAt(0) - 'A';
            tree[root][0] = input[1].charAt(0);
            tree[root][1] = input[2].charAt(0);
        }

        StringBuilder sb = new StringBuilder();

        // 전위 순회
        preorder('A', sb);
        sb.append('\n');

        // 중위 순회
        inorder('A', sb);
        sb.append('\n');

        // 후위 순회
        postorder('A', sb);

        System.out.println(sb);
    }

    // 전위: Root → Left → Right
    static void preorder(char node, StringBuilder sb) {
        if (node == '.') return;

        sb.append(node);
        preorder(tree[node - 'A'][0], sb);
        preorder(tree[node - 'A'][1], sb);
    }

    // 중위: Left → Root → Right
    static void inorder(char node, StringBuilder sb) {
        if (node == '.') return;

        inorder(tree[node - 'A'][0], sb);
        sb.append(node);
        inorder(tree[node - 'A'][1], sb);
    }

    // 후위: Left → Right → Root
    static void postorder(char node, StringBuilder sb) {
        if (node == '.') return;

        postorder(tree[node - 'A'][0], sb);
        postorder(tree[node - 'A'][1], sb);
        sb.append(node);
    }
}
