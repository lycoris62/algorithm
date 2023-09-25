import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zeros = 0;
        String str = s;
        
        while (!str.equals("1")) {
            int ones = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') 
                    ones++;
            }
            
            cnt++;
            zeros += (str.length() - ones);
            str = Integer.toBinaryString(ones);
        }
        
        return new int[] {cnt, zeros};
    }
}