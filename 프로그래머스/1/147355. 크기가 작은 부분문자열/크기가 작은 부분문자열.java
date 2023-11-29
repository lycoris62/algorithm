class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pLong = Long.parseLong(p);
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String sub = t.substring(i,i + p.length());
            
            long parseLong = Long.parseLong(sub);
            if (parseLong <= pLong) answer++;    
        }
        
        return answer;
    }
}