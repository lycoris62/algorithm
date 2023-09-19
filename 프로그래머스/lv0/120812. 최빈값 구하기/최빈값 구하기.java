import java.util.*;

class Solution {
    public int solution(int[] array) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int maxCnt = 0;
        
        for (int x : array) {
            int cnt = map.getOrDefault(x, 0) + 1;
            map.put(x, cnt);
            
            if (maxCnt < cnt) {
                maxCnt = cnt;
                max = x;
            }
        }
        
        int freq = 0;
        for (int x : map.values()) {
            if (x == maxCnt) freq++;
        }
        
        return freq > 1 ? -1 : max;
    }
}