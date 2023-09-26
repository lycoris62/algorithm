import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] arr = my_string.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.isUpperCase(arr[i]) 
                ? Character.toLowerCase(arr[i]) 
                : Character.toUpperCase(arr[i]);
        }
        return String.valueOf(arr);
    }
}