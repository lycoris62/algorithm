import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        String str = new StringBuilder(String.valueOf(arr)).reverse().toString();
        System.out.println(str);
    }
}
