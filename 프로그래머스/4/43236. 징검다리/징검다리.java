import java.util.*;

class Solution {
    
    int answer = 0;

    public int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getRemovedRockCnt(rocks, mid, distance) <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public int getRemovedRockCnt(int[] rocks, int mid, int distance) {
        int before = 0;
        int end = distance;

        int removeCnt = 0;
        for (int rock : rocks) {
            if (rock - before < mid) {
                removeCnt++;
                continue;
            }
            
            before = rock;
        }
        
        if (end - before < mid) {
            removeCnt++;
        }

        return removeCnt;
    }
}