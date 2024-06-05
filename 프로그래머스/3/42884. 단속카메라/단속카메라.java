import java.util.*;

class Solution {
    
    int cameraCount = 0;
    int lastEndTime = Integer.MIN_VALUE;
    List<Car> cars = new ArrayList<>();
    
    public int solution(int[][] routes) {
        
        for (int[] route : routes) {
            cars.add(new Car(route[0], route[1]));
        }
        
        Collections.sort(cars);
        
        for (Car car : cars) {
            if (lastEndTime < car.startTime) {
                lastEndTime = car.endTime;
                cameraCount++;
            }
        }
        
        return cameraCount;
    }
    
    class Car implements Comparable<Car> {
        
        int startTime, endTime;
        
        public Car(int startTime, int endTime) {
            this.startTime = startTime; 
            this.endTime = endTime;
        }
        
        @Override
        public int compareTo(Car o) {
            return Integer.compare(this.endTime, o.endTime);
        }
    }
}