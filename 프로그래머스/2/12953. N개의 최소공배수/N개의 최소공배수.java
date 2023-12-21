class Solution {
    public int solution(int[] arr) {
        
        int answer = arr[0];
        int g;
        
        for (int i = 1; i < arr.length; i++) {
            g = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / g;
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        int r = a % b;
        return r == 0 ? b : gcd(b, r);
    }
}