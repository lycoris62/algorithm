import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] ans = Arrays.stream(arr)
            .sorted()
            .filter(e -> e % divisor == 0)
            .toArray();
        
        return ans.length == 0 ? new int[]{-1} : ans;
    }
}