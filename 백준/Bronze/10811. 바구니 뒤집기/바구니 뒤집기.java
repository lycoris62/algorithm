import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken()) - 1;
            int end = stoi(st.nextToken()) - 1;

            while (start < end) {
                int temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }

        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
