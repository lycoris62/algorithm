class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[] {
            Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        for (int i = 0; i < wallpaper.length; i++) {
            String row = wallpaper[i];
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '.') continue;
                
                answer[0] = Math.min(answer[0], i);
                answer[1] = Math.min(answer[1], j);
                answer[2] = Math.max(answer[2], i + 1);
                answer[3] = Math.max(answer[3], j + 1);
            }
        }
        
        return answer;
    }
}