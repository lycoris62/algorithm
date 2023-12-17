import java.util.*;

class Solution {
    
    Map<String, Integer> simap = new HashMap<>();
    Map<Integer, String> ismap = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        for (int i = 0; i < players.length; i++) {
            simap.put(players[i], i + 1);
            ismap.put(i + 1, players[i]);
        }
        
        for (String call : callings) {
            int rank = simap.get(call);
            String front = ismap.get(rank - 1);
            
            simap.put(call, rank - 1);
            simap.put(front, rank);
            
            ismap.put(rank - 1, call);
            ismap.put(rank, front);
        }
        
        for (int i = 0; i < players.length; i++) {
            answer[i] = ismap.get(i + 1);
        }
        
        return answer;
    }
}