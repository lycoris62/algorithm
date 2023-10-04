import java.util.*;

class Solution {
    
    final int MAX = 1_000_000;
    
    public int solution(int n) {
        int answer = 0;
        int ones = getOneCount(n);
        
        for (int i = n + 1; i <= MAX; i++) {
            if (isOneEquals(ones, i)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    private boolean isOneEquals(int ones, int nn) {
        return ones == getOneCount(nn);
    }
    
    private int getOneCount(int n) {
        int cnt = 0;
        String bin = Integer.toBinaryString(n);
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') cnt++;
        }
        return cnt;
    }
}