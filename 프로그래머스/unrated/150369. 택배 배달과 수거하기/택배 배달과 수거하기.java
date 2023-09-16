import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<House> del = new Stack<>();
        Stack<House> pick = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                del.push(new House(i + 1, deliveries[i]));
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (pickups[i] != 0) {
                pick.push(new House(i + 1, pickups[i]));
            }
        }
        
        while (!del.isEmpty() || !pick.isEmpty()) {
            int weight = 0;
            int len = 0;
            
            while (!del.isEmpty()) {
                House now = del.pop();
                int maxWeight = Math.min(now.cnt, cap - weight);
                weight += maxWeight;
                len = Math.max(len, now.idx);
                
                if (maxWeight < now.cnt) {
                    del.push(new House(now.idx, now.cnt - maxWeight));
                    break;
                }
            }
            
            weight = 0;
            
            while (!pick.isEmpty()) {
                House now = pick.pop();
                int maxWeight = Math.min(now.cnt, cap - weight);
                weight += maxWeight;
                len = Math.max(len, now.idx);
                
                if (maxWeight < now.cnt) {
                    pick.push(new House(now.idx, now.cnt - maxWeight));
                    break;
                }
            }
            
            answer += len * 2;
        }
        
        return answer;
    }
    
    class House {
        int idx, cnt;
        public House(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
        public String toString() {
            return "[" + idx + ", " + cnt + "]";
        }
    }
}