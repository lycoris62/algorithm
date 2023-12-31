class Solution {
    public int[] solution(long n) {
        return new StringBuilder().append(n)
            .reverse()
            .chars()
            .map(Character::getNumericValue)
            .toArray();
    }
}