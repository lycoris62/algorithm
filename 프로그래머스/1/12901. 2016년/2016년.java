class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] daysOfWeek = {"THU", "FRI","SAT","SUN","MON","TUE","WED"};
        int[] daysOfMonth = {31, 29, 31,30,31,30, 31, 31, 30,31, 30, 31};
        
        int daysOfYear = 0; 
        for (int i = 0; i < a - 1; i++) {
            daysOfYear += daysOfMonth[i];
        }
        daysOfYear += b;
        
        
        return daysOfWeek[daysOfYear % 7];
    }
}