import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes, Comparator.reverseOrder());
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(ropes[i].intValue() * (i + 1), max);
        }
        System.out.println(max);
    }
}