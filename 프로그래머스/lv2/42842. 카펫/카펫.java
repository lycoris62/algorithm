class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int length = (brown - 4) / 2;
        
        for (int width = length - 1; width >= length / 2; width--) {
            if (width * (length - width) == yellow) {
                answer = new int[] {width + 2, length - width + 2};
                break;
            }
        }
        
        return answer;
    }
}