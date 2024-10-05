import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        list.add(0);

        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());

            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
                continue;
            }

            int left = 0;
            int right = list.size() - 1;

            while (left < right) {
                int mid = (left + right) / 2;

                if (list.get(mid) >= arr[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            list.set(right, arr[i]);
        }

        System.out.println(list.size() - 1);
    }
}
