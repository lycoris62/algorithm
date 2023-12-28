class Solution {
    
    boolean[] visited;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    private void dfs(int depth, int stress, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > stress) {
                continue;
            }
            
            visited[i] = true;
            dfs(depth + 1, stress - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        
        answer = Math.max(answer, depth);
    }
}