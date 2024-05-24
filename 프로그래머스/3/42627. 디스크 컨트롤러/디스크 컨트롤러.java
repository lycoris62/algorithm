import java.util.*;

class Solution {
    
    int answer = 0;
    int end = 0;
    int jobsIdx = 0;
    int count = 0;
    Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        while (count < jobs.length) { // 모든 요청을 수행 
            
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }
            
            if (pq.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else {
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        
        return (int) Math.floor(answer / jobs.length);
    }
    
    class Job implements Comparable<Job> {
        int start, time;
        
        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
        
        public int compareTo(Job o) {
            return Integer.compare(this.time, o.time);
        }
    }
}