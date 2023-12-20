class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int length = (brown - 4) / 2;
        
        for (int width = length - 1; width >= length / 2; width--) {
            int height = length - width;
            if (width * height == yellow) {
                answer = new int[] { width + 2, height + 2 };
                break;
            }
        }
        
        return answer;
    }
}