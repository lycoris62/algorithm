import java.util.*;

class Solution {
    
    char[] arr;
    char[] ops = {'+', '-'};
    int[] numbers;
    int N, target;
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        // 순서 있음 -> 순열 
        // 완전 탐색, 각 자리마다 +나 -를 정해서 배열을 완성 후 종료조건에서 타겟넘버가 되는지 체크
        N = numbers.length;
        this.target = target;
        this.numbers = numbers;
        arr = new char[N];
        
        dfs(0);
        
        return answer;
    }
    
    void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                char op = arr[i];
                if (op == '+') {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < 2; i++) {
            arr[depth] = ops[i];
            dfs(depth + 1);
        }
    }
}