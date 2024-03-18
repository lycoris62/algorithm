import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] nums, temp;
    static Map<Integer, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        nums = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = stoi(st.nextToken());
            nums[i] = x;
            temp[i] = x;
        }

        // 1. 정렬 O(NlogN)
        Arrays.sort(temp);

        // 2. 차례대로 Map 에다가 INCR O(N)
        int count = 0;
        for (int x : temp) {
            if (!map.containsKey(x)) {
                map.put(x, count++);
            }
        }

        // 3. 원본 배열과 Map 이용해서 좌표압축
        for (int num : nums) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}
