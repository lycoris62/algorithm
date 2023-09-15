import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int citylen = g.length;
        long answer = Long.MAX_VALUE;
        long start = 0;
        long end = (long) (10e9 * 2 * 10e5);
        
        while (start < end) {
            long mid = (start + end) / 2;
            int gold = 0;
            int silver = 0;
            int total= 0;
            
            for (int i = 0; i < citylen; i++) {
                long move = (mid / t[i] + 1) / 2;
            
                gold += Math.min(g[i], move * w[i]);
                silver += Math.min(s[i], move * w[i]);
                total += Math.min(g[i] + s[i], move * w[i]);
            }
            
            if (a <= gold && b <= silver && a + b <= total) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return end;
    }
}