import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());

        while (N-- > 0) {
            sol(br.readLine());
        }

        System.out.println(sb);
    }

    static void sol(String str) {
        if (isPalindrome(str, 0, str.length() - 1)) {
            sb.append(0).append("\n");
            return;
        }

        if (isOneRemovedPalindrome(str, 0, str.length() - 1)) {
            sb.append(1).append("\n");
            return;
        }

        sb.append(2).append("\n");
    }

    static boolean isPalindrome(String str, int left, int right) {
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    static boolean isOneRemovedPalindrome(String str, int left, int right) {
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return isPalindrome(str, left + 1, right) || isPalindrome(str, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }
}
