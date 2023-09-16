import java.util.*;

class Solution {
    
    static final int MONTH_DAYS = 28;
    static final int YEAR_DAYS = 12 * 28;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int iToday = getTimestamp(today);
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] arr = term.split(" ");
            termMap.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            int timestamp = getTimestamp(arr[0]) + MONTH_DAYS * termMap.get(arr[1]) - 1;
            if (timestamp < iToday) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int getTimestamp(String date) {
        int[] intDate = Arrays.stream(date.split("[.]"))
            .mapToInt(Integer::parseInt).toArray();

        int timestamp = intDate[2] + intDate[1] * MONTH_DAYS + intDate[0] * YEAR_DAYS;
        
        return timestamp;
    }
}