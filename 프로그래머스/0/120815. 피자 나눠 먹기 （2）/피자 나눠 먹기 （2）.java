class Solution {
    public int solution(int n) {
        int answer = 1;
        // 피자 한 판은 6조각
        // n명은 1~100 
        // 6과 n의 최소공배수에 6나눠주기 
        
        // 최소공배수 구현
        // n>=1 이니까 최소 1판부터 시작하고, while 문으로 나눠지면 리턴 
        while (true) {
            if (answer * 6 % n == 0) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}