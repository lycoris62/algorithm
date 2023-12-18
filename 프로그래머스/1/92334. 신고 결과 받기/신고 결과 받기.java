import java.util.*;

class Solution {
    
    Map<String, Integer> reportCountMap = new HashMap<>();
    Map<String, List<String>> reportListMap = new HashMap<>();
    
    public int[] solution(String[] id_list, String[] report, int k) {
        
        for (String user : id_list) {
            reportCountMap.put(user, 0);
            reportListMap.put(user, new ArrayList<>());
        }
        
        for (String rep : report) {
            String[] splits = rep.split(" ");
            String fromUser = splits[0];
            String toUser = splits[1];
            
            List<String> reportListByFromUser = reportListMap.get(fromUser);
            
            // 이미 from 이 to 를 신고한 경우 continue
            if (reportListByFromUser.contains(toUser)) {
                continue;
            }
            // 신고 안 한 경우 신고 후 피신고수 + 1 
            reportListByFromUser.add(toUser);
            reportCountMap.put(toUser, reportCountMap.get(toUser) + 1);
        }
        
        return Arrays.stream(id_list)
            .mapToInt(fromUser -> (int) reportListMap.get(fromUser)
                    .stream()
                    .filter(toUser -> reportCountMap.get(toUser) >= k)
                    .count())
            .toArray();
    }
}