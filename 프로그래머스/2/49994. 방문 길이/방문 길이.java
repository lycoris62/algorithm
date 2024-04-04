import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> ans = new HashSet<>();
        boolean[][] visited = new boolean[11][11];
        Map<Character, int[]> dirMap = Map.of(
            'U', new int[]{1, 0},
            'R', new int[]{0, 1},
            'D', new int[]{-1, 0},
            'L', new int[]{0, -1}
        );
        
        int[] now = {5, 5};
        
        for (char ch : dirs.toCharArray()) {
            int[] dir = dirMap.get(ch);
            int nx = now[0] + dir[0];
            int ny = now[1] + dir[1];
            
            if ((0 <= nx && nx < 11) && (0 <= ny && ny < 11)) {
                ans.add(now[0]+" "+now[1]+" "+nx+" "+ny);
                ans.add(nx+" "+ny+" "+now[0]+" "+now[1]);
                
                now[0] = nx;
                now[1] = ny;
            }
        }
        
        return ans.size() / 2;
    }
}