class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        String[] strs = s.toLowerCase().split("");
        boolean flag = true;
        
        for (String str : strs) {
            sb.append(flag ? str.toUpperCase() : str);
            flag = str.equals(" ");
        }
        
        return sb.toString();
    }
}