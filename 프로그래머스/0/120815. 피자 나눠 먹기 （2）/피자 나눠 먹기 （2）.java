class Solution {
    public int solution(int people) {
        int pizza = 1;
        while (true) {
            if (pizza * 6 % people == 0) {
                break;
            }
            pizza++;
        }
        
        return pizza;
    }
}