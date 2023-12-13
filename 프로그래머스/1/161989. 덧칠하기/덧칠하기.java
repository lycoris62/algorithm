class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int maxLen = 0; 
        
        for (int paint : section) {
            if (maxLen < paint) {
                answer++;
                maxLen = paint + m - 1;
            }
        }
        
        return answer;
    }
}