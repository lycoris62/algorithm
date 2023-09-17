import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(long[] numbers) {
        
        return IntStream.range(0, numbers.length)
            .map(i -> checkTree(getBinaryTree(numbers[i])) ? 1 : 0)
            .toArray();
    }
    
    private String getBinaryTree(long n) {
        
        String binary = Long.toBinaryString(n);
        int height = (int) Math.ceil(Math.log10(binary.length() + 1) / Math.log10(2));
        int size = (int) Math.pow(2, height) - 1;
        int dummy = size - binary.length();
        
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, dummy).forEach(i -> sb.append("0"));
        sb.append(binary);
        
        return sb.toString();
    }
    
    private boolean checkTree(String binaryTree) {
        
        int len = binaryTree.length();
        
        if (len <= 1) 
            return true;
        
        String leftTree = binaryTree.substring(0, len / 2);
        String rightTree = binaryTree.substring(len / 2 + 1);
        
        char root = binaryTree.charAt(len / 2);
        char left = leftTree.charAt(leftTree.length() / 2);
        char right = rightTree.charAt(rightTree.length() / 2);
        
        if (root == '0' && (left == '1' || right == '1')) {
            return false;
        } else {
            return checkTree(leftTree) && checkTree(rightTree);
        }
    }
}