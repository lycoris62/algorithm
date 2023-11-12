public class Solution {
    public int solution(int n) {
        int answer = 0;
        char[] chars = String.valueOf(n).toCharArray();
        
        for (char ch : chars) {
            answer += ch - '0';
        }
        
        return answer;
    }
}