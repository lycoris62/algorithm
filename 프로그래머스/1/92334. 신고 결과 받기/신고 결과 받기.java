import java.util.*;

class Solution {
    
    Map<String, Integer> reportCountMap = new HashMap<>();
    Map<String, List<String>> reportListMap = new HashMap<>();
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
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
        
        // k번 신고 당한 유저는 1메일
        // 신고 한 유저도 1메일 
        
        int[] result = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            // // 본인이 k번 신고 당한 경우 메일 +1
            // if (reportCountMap.get(user) >= k) {
            //     result[i]++;
            // }
            // 본인이 신고한 유저들의 신고 횟수가 k번 이상인 경우 그 경우당 메일 +1 
            List<String> reportList = reportListMap.get(user);
            for (String toUser : reportList) {
                if (reportCountMap.get(toUser) >= k) {
                    result[i]++;
                }
            }
        }
        
        
        
        // return Arrays.stream(id_list)
        //     .mapToInt(toUser -> reportCountMap.get(toUser))
        //     .toArray();
        
        // return answer;
        return result;
    }
}