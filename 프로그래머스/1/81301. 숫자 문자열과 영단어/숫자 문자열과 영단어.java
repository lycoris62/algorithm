import java.util.*;

class Solution {
    
    Map<String, String> parser = Map.of(
        "zero", "0",
        "one", "1",
        "two", "2",
        "three", "3",
        "four", "4",
        "five", "5",
        "six", "6",
        "seven", "7",
        "eight", "8",
        "nine", "9"
    );
    
    public int solution(String s) {
        int answer = 0;
        
        for (Map.Entry<String, String> entry : parser.entrySet()) {
            s = s.replace(entry.getKey(), entry.getValue()); // String 은 불변,,, 잊지마 
        }
        
        return Integer.parseInt(s);
    }
}