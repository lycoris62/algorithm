import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, length = 1;
    static int[] arr, list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        arr = new int[N + 1];
        list = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        list[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            if (list[length] < arr[i]) {
                list[length + 1] = arr[i];
                length++;
            } else {
                list[binarySearch(arr[i], 1, length)] = arr[i];
            }
        }

        System.out.println(length);
    }

    static int binarySearch(int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (list[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
