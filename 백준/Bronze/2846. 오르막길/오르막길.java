import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, answer, height;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            if (arr[i - 1] < arr[i]) {
                height += arr[i] - arr[i - 1];
                answer = Math.max(answer, height);
            } else {
                height = 0;
            }
        }

        System.out.println(answer);
    }
}
