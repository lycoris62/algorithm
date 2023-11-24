class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            sb.append(change(str)).append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }
    
    private String change(String raw) {
        char[] chars = raw.toCharArray();
        
        for (int i = 0; i < raw.length(); i++) {
            chars[i] = i % 2 == 0 ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]);
        }
        
        return String.valueOf(chars);
    }
}