import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static Node root = new Node("root");
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            K = stoi(st.nextToken());
            Node now = root;

            while (st.hasMoreTokens()) {
                String name = st.nextToken();

                if (!now.children.containsKey(name)) {
                    now.children.put(name, new Node(name));
                }

                now = now.children.get(name);
            }
        }

        root.children.values().stream().sorted().forEach(child -> print(child, 0));

        System.out.println(sb);
    }

    static void print(Node now, int depth) {
        sb.append("--".repeat(depth)).append(now.name).append("\n");
        now.children.values().stream().sorted().forEach(child -> print(child, depth + 1));
    }

    static class Node implements Comparable<Node> {
        String name;
        Map<String, Node> children = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }

        public int compareTo(Node o) {
            return this.name.compareTo(o.name);
        }
    }
}
