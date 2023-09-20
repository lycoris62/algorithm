import java.util.*;

class Solution {
    
    int stoi(String str) {
        return Integer.parseInt(str);
    }
    
    int convert(int x, int y) {
        return 50 * (x - 1) + y;
    }
    
    int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            parents[bRoot] = aRoot;
        }
    }
    
    int[] parents = new int[2501];
    String[] values = new String[2501];
    List<String> res = new ArrayList<>();
    
    public String[] solution(String[] commands) {
        StringTokenizer st;
        for (int i = 1; i <= 2500; i++) {
            parents[i] = i;
            values[i] = "";
        }
        
        for (String command : commands) {
            st = new StringTokenizer(command);
            String order = st.nextToken();
            
            switch(order) {
                case "UPDATE":
                    int cnt = st.countTokens();
                    if (cnt == 3) {
                        int idx = convert(stoi(st.nextToken()), stoi(st.nextToken()));
                        values[find(idx)] = st.nextToken();
                    }
                    else {
                        String before = st.nextToken();
                        String after = st.nextToken();
                        for (int i = 1; i <= 2500; i++) {
                            if (values[i].equals(before)) {
                                values[i] = after;
                            }
                        }
                    }
                    break;
                case "PRINT":
                    int idxPR = convert(stoi(st.nextToken()), stoi(st.nextToken()));
                    int rootPR = find(idxPR);
                    res.add(values[rootPR].isBlank() ? "EMPTY" : values[rootPR]);
                    break;
                case "MERGE":
                    int idx1 = convert(stoi(st.nextToken()), stoi(st.nextToken()));
                    int idx2 = convert(stoi(st.nextToken()), stoi(st.nextToken()));
                    int root1 = find(idx1);
                    int root2 = find(idx2);
                    
                    if (root1 == root2) continue;
                    
                    String rootStr = values[root1].isBlank() ? values[root2] : values[root1];
                    values[root1] = "";
                    values[root2] = "";
                    
                    union(root1, root2);
                    values[root1] = rootStr;
                    
                    break;
                case "UNMERGE":
                    int idxUM = convert(stoi(st.nextToken()), stoi(st.nextToken()));
                    int rootUM = find(idxUM);
                    String rootStrUM = values[rootUM];
                    values[rootUM] = "";
                    values[idxUM] = rootStrUM;
                    List<Integer> deleteList = new ArrayList<>();
                    for (int i = 1; i <= 2500; i++) {
                        if (find(i) == rootUM) {
                            deleteList.add(i);
                        }
                    }
                    
                    for (int x : deleteList) {
                        parents[x] = x;
                    }
                    
                    break;
            }
        }
        
        return res.toArray(String[]::new);
    }
}