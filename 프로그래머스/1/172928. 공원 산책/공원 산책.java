import java.util.*;

class Solution {
    Map<String, int[]> dirMap = Map.of(
    "E", new int[]{0, 1}, 
    "W", new int[]{0, -1}, 
    "S", new int[]{1, 0},
    "N", new int[]{-1, 0});
    
    public int[] solution(String[] park, String[] routes) {
        int N = park.length;
        int M = park[0].length();
        Node now = new Node();
        
        for (int i = 0; i < N; i++) {
            String row = park[i];
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == 'S') {
                    now.x = i;
                    now.y = j;
                    break;
                }
            }
        }
        
        for (String comm : routes) {
            String[] splits = comm.split(" ");
            int[] dxy = dirMap.get(splits[0]);
            int move = Integer.parseInt(splits[1]);
            
            Node next = new Node();
            next.x = now.x;
            next.y = now.y;
            
            for (int i = 0; i < move; i++) {
                int nx = next.x + dxy[0];
                int ny = next.y + dxy[1];
                
                if ((0 <= nx && nx < N) 
                && (0 <= ny && ny < M) 
                && (park[nx].charAt(ny) != 'X')) {
                    next.x = nx;
                    next.y = ny;
                } else {
                    next = now;
                    break;
                }
            }
            
            now = next;
        }
        
        return new int[] {now.x, now.y};
    }
    
    class Node {
        int x, y;
    }
}