import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[Math.max(N, 3) + 1];
        arr[2] = arr[3] = 1;

        for (int i = 4; i <= N; i++) {
            int min = arr[i - 1];

            if (i % 2 == 0) {
                min = Math.min(min, arr[i / 2]);
            }
            if (i % 3 == 0) {
                min = Math.min(min, arr[i / 3]);
            }

            arr[i] = min + 1;
        }

        System.out.println(arr[N]);
    }
}
