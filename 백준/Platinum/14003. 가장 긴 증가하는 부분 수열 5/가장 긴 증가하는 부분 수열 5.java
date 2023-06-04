import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr, list, record;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        arr = new int[N + 1];
        list = new int[N + 1];
        record = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        list[1] = arr[1];
        record[1] = 1;
        int length = 1;

        for (int i = 2; i <= N; i++) {
            if (list[length] < arr[i]) {
                list[++length] = arr[i];
                record[i] = length;
            } else {
                int idx = binarySearch(arr[i], 1, length);
                list[idx] = arr[i];
                record[i] = idx;
            }
        }

        sb.append(length).append("\n");

        for (int i = N; i >= 1; i--) {
            if (record[i] == length) {
                stack.push(arr[i]);
                length--;
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        
        System.out.println(sb);
    }

    static int binarySearch(int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > list[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
