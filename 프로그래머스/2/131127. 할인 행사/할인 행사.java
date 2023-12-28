import java.util.*;

class Solution {
    
    Map<String, Integer> wants = new HashMap<>();
    Map<String, Integer> cart = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length; i++) {
            String item = discount[i];
            cart.put(item, cart.getOrDefault(item, 0) + 1);
            
            if (i >= 10) {
                String prevItem = discount[i - 10];
                cart.put(prevItem, cart.get(prevItem) - 1);
                if (cart.get(prevItem) == 0) {
                    cart.remove(prevItem);
                }
            }
            
            if (isEquals()) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isEquals() {
        for (String key : wants.keySet()) {
            if (!cart.containsKey(key) || wants.get(key) != cart.get(key)) {
                return false;
            }
        }
        return true;
    }
}