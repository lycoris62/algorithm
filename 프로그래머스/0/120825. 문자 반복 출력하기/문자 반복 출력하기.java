class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : my_string.toCharArray()) {
            sb.append(String.valueOf(ch).repeat(n));
        }
        
        return sb.toString();
    }
}