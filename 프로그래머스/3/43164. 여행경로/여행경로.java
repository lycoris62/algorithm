import java.util.*;

class Solution {
    
    String[][] tickets;
    boolean[] visited;
    List<String> paths = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN");
        
        Collections.sort(paths);
        
        return paths.get(0).split(" ");
    }
    
    void dfs(int depth, String now, String path) {
        if (depth == tickets.length) {
            paths.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String next = tickets[i][1];
                
            if (now.equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(depth + 1, next, path + " " + next);
                visited[i] = false;
            }
        }
    }
}