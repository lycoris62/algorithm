class Solution {
    public boolean solution(int x) {
        return x % String.valueOf(x).chars().map(Character::getNumericValue).sum() == 0;
    }
}