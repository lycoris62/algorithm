class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        
        for (char ch : chars) {
            if (ch == ' ') {
                sb.append(" ");
                continue;
            }
            
            if (ch <= 'Z') {
                ch += n;
                if (ch > 'Z') ch -= 26;
            } else {
                ch += n;
                if (ch > 'z') ch -= 26;
            }
            sb.append((char) ch);
        }
        
        return sb.toString();
    }
}