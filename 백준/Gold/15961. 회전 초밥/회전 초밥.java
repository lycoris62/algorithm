import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, D, K, C, left, right;
    static int[] arr;
    static int count, answer;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        D = stoi(st.nextToken());
        K = stoi(st.nextToken());
        C = stoi(st.nextToken());

        int length = N + K - 1;
        arr = new int[length];

        for (int i = 0; i < N; i++) {
            arr[i] = stoi(br.readLine());
        }
        for (int i = 0; i < K - 1; i++) {
            arr[N + i] = arr[i];
        }

        while (right < length) {
            if (count < K) {
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                count++;
                right++;
            }

            if (count == K) {
                int kind = map.size();
                if (!map.containsKey(C)) {
                    kind++;
                }
                answer = Math.max(answer, kind);

                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
                count--;
            }
        }

        System.out.println(answer);
    }
}
