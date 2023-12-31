class Solution {
    public long solution(int a, int b) {
        long x = Math.min(a, b);
        long y = Math.max(a, b);
        return (y - x + 1) * (x + y) / 2;
    }
}