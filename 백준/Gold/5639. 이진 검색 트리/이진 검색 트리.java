import java.io.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static Node head;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String str = br.readLine();
            if (str == null || str.equals(""))
                break;
            insert(stoi(str));
        }

        postOrder(head);
        System.out.println(sb);
    }

    static void insert(int x) {
        Node now = head;
        if (head == null) {
            head = new Node(x);
            return;
        }

        while (true) {
            if (x < now.data) {
                if (now.left == null) {
                    now.left = new Node(x);
                    break;
                } else {
                    now = now.left;
                }
            } else {
                if (now.right == null) {
                    now.right = new Node(x);
                    break;
                } else {
                    now = now.right;
                }
            }
        }
    }

    static void postOrder(Node node) {
        if (node.left != null)
            postOrder(node.left);
        if (node.right != null)
            postOrder(node.right);
        sb.append(node.data).append("\n");
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
