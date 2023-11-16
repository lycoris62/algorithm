import java.util.*;

class Solution {
    public long solution(long n) {
        int[] ints = new StringBuilder().append(n)
            .toString()
            .chars()
            .map(Character::getNumericValue)
            .toArray();
        
        int[] answer = new int[ints.length];
        Arrays.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            answer[ints.length - 1 - i] = ints[i];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i);
        }
        
        return Long.parseLong(sb.toString());
    }
}