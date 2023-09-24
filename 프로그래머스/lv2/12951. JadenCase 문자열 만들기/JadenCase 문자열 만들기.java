class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        String[] chars = s.toLowerCase().split("");
        boolean flag = true;
        
        for (String ch : chars) {
            sb.append(flag ? ch.toUpperCase() : ch);
            flag = ch.equals(" ");
        }
        
        return sb.toString();
    }
}