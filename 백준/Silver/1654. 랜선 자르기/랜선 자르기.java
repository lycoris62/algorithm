import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static int[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = stoi(st.nextToken());
        N = stoi(st.nextToken());

        lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = stoi(br.readLine());
        }

        long left = 1;
        long right = Arrays.stream(lines).max().getAsInt();

        // upper bound
        while (left <= right) {
            long mid = (left + right) >>> 1;

            long count = 0;
            for (int line : lines) {
                count += line / mid;
            }

            // N보다 크면, 더 큼직하게 잘라도 되므로 왼쪽 버리기
            // N와 같으면, N와 같은 횟수 중에서 더 큼직하게 잘라도 되는 길이 구하기
            if (count >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left - 1); // N를 초과하는 첫 번째 값이므로, -1 해줘서 최댓값 구함
    }
}
