import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
    static int N;
    static Map<String, Node> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String value = st.nextToken();
            String leftValue = st.nextToken();
            String rightValue = st.nextToken();
            Node leftNode;
            Node rightNode;

            if (leftValue.equals(".")) leftNode = null;
            else {
                leftNode = new Node(leftValue, null, null);
                map.put(leftValue, leftNode);
            }
            if (rightValue.equals(".")) rightNode = null;
            else {
                rightNode = new Node(rightValue, null, null);
                map.put(rightValue, rightNode);
            }

            if (!map.containsKey(value)) {
                map.put(value, new Node(value, leftNode, rightNode));
            } else {
                Node node = map.get(value);
                node.left = leftNode;
                node.right = rightNode;
            }
        }
        preorder(map.get("A"));
        System.out.println();
        inorder(map.get("A"));
        System.out.println();
        postorder(map.get("A"));

    }

    static void preorder(Node node) {
        if (node.value != null) System.out.print(node.value);
        if (node.left != null) preorder(node.left);
        if (node.right != null) preorder(node.right);
    }
    static void inorder(Node node) {
        if (node.left != null) inorder(node.left);
        if (node.value != null) System.out.print(node.value);
        if (node.right != null) inorder(node.right);
    }
    static void postorder(Node node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        if (node.value != null) System.out.print(node.value);
    }
}

class Node {
    String value;
    Node left;
    Node right;

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
