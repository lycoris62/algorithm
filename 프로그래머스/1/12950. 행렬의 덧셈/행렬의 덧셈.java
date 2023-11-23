class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int R = arr1.length;
        int C = arr1[0].length;
        
        int[][] answer = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}