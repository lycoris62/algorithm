import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        return Arrays.stream(numbers).map(i -> 2 * i).toArray();
    }
}