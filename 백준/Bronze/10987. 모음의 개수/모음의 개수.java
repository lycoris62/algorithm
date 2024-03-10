import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        int cnt = 0;

        for (char ch : word.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
