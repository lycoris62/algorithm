import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        // 시간 제한 0.5초, N <= 1만. O(N^2) -> 1억으로 시간 초과
        // O(N)의 투 포인터로 풀이.

        // 누적합부터. -> 아님. 변수 하나면 됨.
        // M이 되면 answer++
        // M보다 작으면 right++
        // M보다 크면 left--;

        // 누적합 쓰면 N * 4byte 만큼 메모리 낭비.
        // 변수 하나에 저장하면 4byte만 쓰면 됨.... 멍청한 자식
        // 거기에 편의용 길이 1 추가 안 해도 됨...

        int sum = arr[0];
        int left = 0;
        int right = 0;

        while (left < N) {
            if (sum == M) {
                answer++;
            }

            if (right == N - 1) {
                sum -= arr[left++];
                continue;
            }

            if (sum > M) {
                sum -= arr[left++];
            } else {
                sum += arr[++right];
            }
        }

        System.out.println(answer);
    }
}
