class Solution {
    public String solution(String s) {
        return s.length() % 2 == 0 
            ? s.substring(s.length() / 2 - 1, s.length() / 2 + 1)
            : s.substring(s.length() / 2, s.length() / 2 + 1);
    }
}