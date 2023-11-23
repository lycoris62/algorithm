class Solution {
    public int[] solution(int n, int m) {
        return new int[]{gdc(n, m), lcm(n, m)};
    }
    
    private int gdc(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        
        while (min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }
        
        return max;
    }
    
    private int lcm(int n, int m) {
        return n * m / gdc(n, m);
    }
}