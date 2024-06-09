class Solution {

    int length;
    int[] dpO, dpX;

    public int solution(int[] money) {

        length = money.length;
        dpO = new int[length];
        dpX = new int[length];

        dpO[0] = dpO[1] = money[0];
        dpX[1] = money[1];

        for (int i = 2; i < length; i++) {
            dpO[i] = Math.max(dpO[i - 1], money[i] + dpO[i - 2]);
            dpX[i] = Math.max(dpX[i - 1], money[i] + dpX[i - 2]);
        }

        return Math.max(dpO[length - 2], dpX[length - 1]);
    }
}