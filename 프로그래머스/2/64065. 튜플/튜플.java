import java.util.*;
import java.util.function.Function;

class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new LinkedHashSet<>();
        
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] strs = s.split("-");
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        
        Arrays.stream(strs)
            .map(str -> Arrays.stream(str.split(",")).mapToInt(Integer::parseInt))
            .flatMapToInt(Function.identity())
            .forEach(set::add);
        
        return set.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}