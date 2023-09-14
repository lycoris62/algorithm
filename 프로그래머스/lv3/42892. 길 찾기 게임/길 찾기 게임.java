import java.util.*;

class Solution {
    List<Integer> preList = new ArrayList<>();
    List<Integer> postList = new ArrayList<>();
    int[][] answer;
    int infolen;
    
    public int[][] solution(int[][] nodeinfo) {
        infolen = nodeinfo.length;
        answer = new int[2][infolen];
        Input[] inputs = new Input[infolen];
        
        for (int i = 0; i < infolen; i++) {
            inputs[i] = new Input(i + 1, nodeinfo[i]);
        }
        
        Arrays.sort(inputs);
        
        Node root = new Node(inputs[0].index, inputs[0].info[0]);
        
        for (int i = 1; i < inputs.length; i++) {
            int X = inputs[i].info[0];
            Node now = root;
            
            while (true) {
                if (now.X < X) {
                    if (now.right == null) {
                        now.right = new Node(inputs[i].index, X);
                        break;
                    } 
                    now = now.right;
                } else {
                    if (now.left == null ) {
                        now.left = new Node(inputs[i].index, X);
                        break;
                    }
                    now = now.left;
                }
            }
        }
        
        preorder(root);
        postorder(root);

        for (int i = 0; i < infolen; i++) {
            answer[0][i] = preList.get(i);
        }
        
        for (int i = 0; i < infolen; i++) {
            answer[1][i] = postList.get(i);
        }
        
        return answer;
    }
    
    public void preorder(Node node) {
        if (node != null) {
            preList.add(node.value);
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            postList.add(node.value);
        }
    }
    
    class Input implements Comparable<Input> {
        int index;
        int[] info;
        
        public Input(int index, int[] info) {
            this.index = index;
            this.info = info;
        }
        
        public int compareTo(Input i) {
            return this.info[1] == i.info[1] 
                ? this.info[0] - i.info[0] 
                : i.info[1] - this.info[1];
        }
    }
    
    class Node {
        int value, X;
        Node left,right;
        
        public Node(int value, int X) {
            this.value = value;
            this.X = X;
        }
    }
}