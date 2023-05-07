import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int E, F, sum = 0;
    static int[] arr = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            arr[i] = stoi(br.readLine());
        }
        E = stoi(br.readLine());
        F = stoi(br.readLine());
        sum += Arrays.stream(arr).sum() - Arrays.stream(arr).min().getAsInt() + Math.max(E, F);
        System.out.println(sum);
    }
}
