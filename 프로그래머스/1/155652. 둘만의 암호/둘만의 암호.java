class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            for (int i = 0; i < index; i++) {
                ch += 1;
                if (ch > 'z') ch = 'a';
                if (skip.contains(String.valueOf(ch))) i--;
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}