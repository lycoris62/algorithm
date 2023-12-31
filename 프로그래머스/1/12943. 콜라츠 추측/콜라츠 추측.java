class Solution {
    public int solution(long num) {
        long n = (long) num;
        for( int i = 0; i < 500; i++){
            if (n == 1) 
                return i; 
            n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
        }

        return -1;
    }
}