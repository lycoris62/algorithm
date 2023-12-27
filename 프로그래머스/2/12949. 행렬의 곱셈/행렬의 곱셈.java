class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int N = arr1.length;
        int M = arr2[0].length;
        int temp = arr2.length;
        
        int[][] answer = new int[N][M];
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int mid = 0; mid < temp; mid++) {
                    answer[r][c] += arr1[r][mid] * arr2[mid][c];
                }
            }
        }
        
        return answer;
    }
}