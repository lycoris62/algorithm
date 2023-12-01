import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for (int j = 0; j < len; j++) {
            int[] command = commands[j];
            List<Integer> list = new ArrayList<>();
            
            int start = command[0] - 1;
            int end = command[1] - 1;
            int k = command[2] - 1;
            
            for (int i = start; i <= end; i++) {
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[j] = list.get(k);
        }
        
        return answer;
    }
}