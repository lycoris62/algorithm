class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean isFirst = true;
        char x = s.charAt(0);
        int xCnt = 0;
        int notXCnt = 0;
        
        for (char ch : s.toCharArray()) {
            if (isFirst) {
                x = ch;
                xCnt = 1;
                isFirst = false;
                continue;
            }
            
            if (ch == x) xCnt++;
            else notXCnt++;
            
            if (xCnt == notXCnt) {
                answer++;
                isFirst = true;
                xCnt = notXCnt = 0;
            }
        }
        
        if (xCnt != 0) answer++;
        
        return answer;
    }
}