class Solution {
    public int solution(int people) {
        int pizza = 1;
        while (pizza * 6 % people != 0) {
            pizza++;
        }
        
        return pizza;
    }
}