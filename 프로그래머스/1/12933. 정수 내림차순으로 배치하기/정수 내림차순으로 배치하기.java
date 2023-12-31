import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(String.valueOf(n).split("")).sorted().forEach(e -> sb.append(e));

        return Long.parseLong(sb.reverse().toString());
    }
}