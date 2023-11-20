import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        int min = Arrays.stream(arr).min().getAsInt();
        int[] ans = Arrays.stream(arr).filter(ele -> ele != min).toArray();
        
        return ans.length == 0 ? new int[]{-1} : ans;
    }
}