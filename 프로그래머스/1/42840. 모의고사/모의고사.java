import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {0, 0, 0};
        int[] ones = {1,2,3,4,5};
        int[] twos = {2,1,2,3,2,4,2,5};
        int[] threes = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];
            if (ones[i % ones.length] == ans) answer[0]++;
            if (twos[i % twos.length] == ans) answer[1]++;
            if (threes[i % threes.length] == ans) answer[2]++;
        }
        
        int max = Arrays.stream(answer).max().getAsInt();
        long cnt = Arrays.stream(answer).filter(e -> e == max).count();
        
        int[] arr = new int[(int) cnt];
        int j = 0;
        for (int i = 0; i < 3; i++) {
            if (answer[i] == max) {
                arr[j] = i + 1;
                j++;
            }
        }
        
        return arr;
    }
}