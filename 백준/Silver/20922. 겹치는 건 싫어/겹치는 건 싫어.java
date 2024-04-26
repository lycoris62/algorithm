import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K, maxLen;
    static int[] arr, counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        arr = new int[N];
        counts = new int[100_001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int left = 0;
        int right = 0;

        while (left < N) {

            while (right < N && counts[arr[right]] + 1 <= K) { // 가능한 최대로 right 늘리기
                counts[arr[right++]]++;
            }

            int len = right - left;
            maxLen = Math.max(maxLen, len);

            counts[arr[left++]]--;
        }

        System.out.println(maxLen);
    }
}
