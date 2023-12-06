class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int idx1 = 0;
        int idx2 = 0;
        int idxg = 0;
        
        while (idxg < goal.length) {
            String word = goal[idxg];
            
            if (idx1 < cards1.length && cards1[idx1].equals(word)) {
                idx1++;
                idxg++;
                continue;
            }
            
            if (idx2 < cards2.length && cards2[idx2].equals(word)) {
                idx2++;
                idxg++;
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}