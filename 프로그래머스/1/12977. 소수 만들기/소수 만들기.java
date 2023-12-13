class Solution {
    
    int length = 1000 * 50;
    boolean[] composites = new boolean[length + 1];
    
    private void setPrimes() {
        composites[0] = composites[1] = true;
        
        for (int i = 2; i <= Math.sqrt(length); i++) {
            if (!composites[i]) {
                for (int j = i * i; j <= length; j += i) {
                    composites[j] = true;
                }
            }
        }
    }
    
    public int solution(int[] nums) {
        
        setPrimes();
        int answer = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (!composites[sum]) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}