import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        
        List<Integer> list = Arrays.stream(s.split(" "))
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());
        
        return list.get(0) + " " + list.get(list.size() - 1);
    }
}