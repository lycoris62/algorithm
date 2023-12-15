import java.util.*;

class Solution {
    
    Map<Integer, Boolean> isUsed = new HashMap<>();
    
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int minCount = 0;
        int zeroCount = 0;
        
        for (int lottoNum : lottos) {
            if (Arrays.stream(win_nums).anyMatch(winNum -> winNum == lottoNum)) {
                minCount++;
                isUsed.put(lottoNum, true);
                continue;
            }
            
            if (lottoNum == 0) 
                zeroCount++;
        }
        
        int maxRank = Math.min(7 - minCount - zeroCount, 6);
        int minRank = Math.min(7 - minCount, 6);
        
        return new int[] { maxRank, minRank };
    }
}