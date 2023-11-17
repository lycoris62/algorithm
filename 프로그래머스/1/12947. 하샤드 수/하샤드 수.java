class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = new StringBuilder().append(x)
            .chars()
            .map(Character::getNumericValue)
            .sum();
        
        return x % sum == 0;
    }
}