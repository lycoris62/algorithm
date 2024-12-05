class Solution {
    public int[] solution(int n) {
        int len = (n + 1) / 2;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = 2 * i + 1;
        }
        return answer;
    }
}