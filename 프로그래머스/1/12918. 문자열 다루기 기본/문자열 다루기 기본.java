class Solution {
    public boolean solution(String s) {
        char[] chars = s.toCharArray();
        
        if ((chars.length == 4 || chars.length == 6) && isNumeric(chars)) {
            return true;
        }
        
        return false;
    }
    
    private boolean isNumeric(char[] chs) {
        for (char ch : chs) {
            int value = (int)(ch - '0');
            if (!(0 <= value && value <= 9)) {
                return false;
            }
        }
        return true;
    }
}