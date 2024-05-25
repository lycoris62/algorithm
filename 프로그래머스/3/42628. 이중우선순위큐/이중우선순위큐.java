import java.util.*;

class Solution {
    
    TreeMap<Integer, Integer> map = new TreeMap<>();
    
    public int[] solution(String[] operations) {
        
        for (String operation : operations) {
            String[] arr = operation.split(" ");
            String op = arr[0];
            int value = Integer.parseInt(arr[1]);
            
            if (op.equals("I")) {
                map.put(value, map.getOrDefault(value, 0) + 1);
                continue;
            }
            
            if (map.isEmpty()) {
                continue;
            }
            
            int num = value == 1 ? map.lastKey() : map.firstKey();
            
            int returnValue = map.put(num, map.get(num) - 1); // put은 변경 전 값 리턴 함
            if (returnValue == 1) {
                map.remove(num);
            }
        }
        
        return map.isEmpty() ? new int[]{0, 0} : new int[]{map.lastKey(), map.firstKey()};
    }
}