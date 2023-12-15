import java.util.*;

class Solution {
    
    Map<Integer, Boolean> isUsed = new HashMap<>();
    int[] scores = { 6, 6, 5, 4, 3, 2, 1 };
    
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int minCount = 0;
        int zeros = 0;
        
        for (int lottoNum : lottos) {
            if (Arrays.stream(win_nums).anyMatch(winNum -> winNum == lottoNum)) {
                minCount++;
                isUsed.put(lottoNum, true);
                continue;
            }
            if (lottoNum == 0) zeros++;
        }
        
        int maxCount = minCount;
        
        for (int winNum : win_nums) {
            if (zeros <= 0) break;
            if (isUsed.getOrDefault(winNum, false)) continue;
            
            isUsed.put(winNum, true);
            maxCount++;
            zeros--;
        }
        
        
        return new int[] { scores[maxCount], scores[minCount]};
    }
}