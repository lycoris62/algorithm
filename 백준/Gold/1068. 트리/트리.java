import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, X, answer;
    static Node root;
    static Map<Integer, Node> nodeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        // 우선 모든 노드 미리 만들어놓기. 
        for (int i = 0; i < N; i++) {
            nodeMap.put(i, new Node(i));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parentNum = stoi(st.nextToken());
            
            Node parent = nodeMap.get(parentNum);
            Node child = nodeMap.get(i);

            if (parentNum == -1) { // -1이 첫 번째로 안 나오는 경우가 있음 
                root = child;
            } else {
                child.parent = parent;
                parent.children.add(child);
            }
        }

        X = stoi(br.readLine());

        if (X == root.num) { // 루트 번호가 0이 아닐 수 있음 (-1이 중간에 나오면)
            System.out.println(0);
            return;
        }

        Node removeNode = nodeMap.get(X);
        removeNode.parent.children.remove(removeNode);

        getLeafNodeCount(root);

        System.out.println(answer);
    }

    static void getLeafNodeCount(Node now) {
        // 만약 리프 노드면 개수 1 더하고 리턴
        // 그렇지 않다면, 자식 노드를 재귀로 돌림.

        if (now.isLeaf()) {
            answer++;
            return;
        }

        for (Node child : now.children) {
            getLeafNodeCount(child);
        }
    }

    static class Node {

        int num;
        Node parent;
        List<Node> children = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }
    }
}
