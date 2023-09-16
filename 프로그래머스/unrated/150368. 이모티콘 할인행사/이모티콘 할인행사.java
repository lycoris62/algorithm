import java.util.*;

class Solution {
    
    int m;
    int[] discounts;
    int[] answer = {0, 0};
    
    public int[] solution(int[][] users, int[] emoticons) {
        m = emoticons.length;
        discounts = new int[m];
        dfs(0, users, emoticons);
        return answer;
    }
    
    public void dfs(int depth, int[][] users, int[] emoticons) {
        if (depth == m) {
            int[] res = {0, 0};
            for (int[] user : users) {
                int discount = user[0];
                int price = user[1];
                int total = 0;
                
                for (int i = 0; i < m; i++) {
                    if (discounts[i] >= discount) {
                        total += emoticons[i] * (100 - discounts[i]) / 100;
                    }
                }
                
                if (total >= price) {
                    res[0]++;
                } else {
                    res[1] += total;
                }
            }
            
            if (answer[0] < res[0]) {
                answer = res;
            } else if (answer[0] == res[0] && answer[1] < res[1]) {
                answer = res;
            }
            
            return;
        }
        
        for (int i = 1; i <= 4; i++) {
            discounts[depth] = 10 * i;
            dfs(depth + 1, users, emoticons);
        }
    }
}