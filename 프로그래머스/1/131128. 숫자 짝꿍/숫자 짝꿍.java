import java.util.*;

class Solution {
    
    int[] x = new int[10];
    int[] y = new int[10];
    StringBuilder sb = new StringBuilder();
    
    public String solution(String X, String Y) {
        
        for (int i = 0; i < X.length(); i++) {
            int num = X.charAt(i) - '0';
            x[num]++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            int num = Y.charAt(i) - '0';
            y[num]++;
        }
        
        
        for (int i = 9; i >= 0; i--) {
            int minCount = Math.min(x[i], y[i]);
            String num = String.valueOf(i).repeat(minCount);
            sb.append(num);
        }
        
        String result = sb.toString();
        
        if (result.isEmpty()) return "-1";
        if (result.charAt(0) == '0') return "0";
        return result;
    }
}