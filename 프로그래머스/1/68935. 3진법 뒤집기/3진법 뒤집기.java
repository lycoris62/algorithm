class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        char[] chars = sb.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            answer *= 3;
            answer += chars[i] - '0';
        }
        
        return answer;
    }
}