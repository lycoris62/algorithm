import java.util.*;

class Solution {
    public String solution(String rsp) {
        
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = Map.of(
        '0', '5',
        '2', '0',
        '5', '2');
        for (int i = 0; i < rsp.length(); i++) {
            sb.append(map.get(rsp.charAt(i)));
        }
        return sb.toString();
    }
}