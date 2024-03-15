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
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = stoi(br.readLine());
        }

        Arrays.sort(arr);

        for (int x : arr) {
            System.out.println(x);
        }
    }
}
