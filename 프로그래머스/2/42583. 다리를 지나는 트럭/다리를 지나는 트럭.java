import java.util.*;

class Solution {
    
    Queue<Integer> bridge = new ArrayDeque<>();
    int totalWeight = 0;
    int totalTime = 0;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        for (int truckWeight : truck_weights) {
            while (true) {
                // 다리에 아무 트럭이 없으면 : 트럭 추가 
                if (bridge.isEmpty()) {
                    bridge.add(truckWeight);
                    totalWeight += truckWeight;
                    totalTime++;
                    break;
                }
                
                // 다리 길이만큼 트럭이 다 찬 경우 : 맨 앞 트럭 빼기 
                if (bridge.size() == bridge_length) {
                    totalWeight -= bridge.poll();
                    continue;
                } 
                
                // 밑은 다리 길이만큼 트럭이 차지 않은 경우, 
                
                
                // 다리의 최대 하중보다 낮은 경우 : 트럭 추가 
                if (totalWeight + truckWeight <= weight) {
                    bridge.add(truckWeight);
                    totalWeight += truckWeight;
                    totalTime++;
                    break;
                }

                // 하중 초과인 경우 : 0만 넣어서 트럭 넣지 않고 시간 지남 
                bridge.add(0);
                totalTime++;
            }
        }
        
        return totalTime + bridge_length; // 마지막 트럭이 지나가는 시간 추가 
    }
}