import java.util.*;

class Solution {
    
    int[] nums = new int[10];
    
    public String solution(String X, String Y) {
        for (int i = 0; i < X.length(); i++) {
            int num = X.charAt(i) - '0';
            nums[num]++;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Y.length(); i++) {
            int num = Y.charAt(i) - '0';
            if (nums[num] > 0) {
                nums[num]--;
                list.add(num);
            }
        }
        
        if (list.isEmpty()) return "-1";
        long notZeroCount = list.stream().filter(i -> i != 0).count();
        if (notZeroCount == 0) return "0";
        
        Collections.sort(list, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i : list) sb.append(i);
        
        return sb.toString();
    }
}