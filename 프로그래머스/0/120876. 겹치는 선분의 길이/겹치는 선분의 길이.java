class Solution {
    
    static final int maxLength = 201;
    
    public int solution(int[][] lines) {
        int answer = 0;
        int[] arr = new int[maxLength];
        
        for (int[] line : lines) {
            for (int i = line[0] + 100; i < line[1] + 100; i++) {
                arr[i]++;
            }
        }
        
        for (int i = 0; i < maxLength; i++) {
            if (arr[i] > 1) {
                answer++;
            } 
        }
        
        return answer;
    }
}