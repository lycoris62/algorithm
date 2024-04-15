import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, answer;
    static int[] nums, sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        nums = new int[N];
        sums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = stoi(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = nums[0];

        // 수도코드
        /*

        왼쪽 포인터 <- 0
        오른쪽 포인터 <- 0
        합 <- nums[0]

        while (왼쪽 포인터 < 배열 길이) {
            if (합 == 조건) {
                경우 1 추가 
            }
            
            if (합 > 조건 || 오른쪽 포인터가 끝에 도달) {
                왼쪽 값을 합에서 빼기
                왼쪽 포인터 한 칸 이동
            } else if (합 <= 조건) {
                오른쪽 포인터 한 칸 이동
                그 값을 합에 더하기
            }
        }
         */

        while (left < N) {
            if (sum == M) {
                answer++;
            }
            
            if (sum > M || right == N - 1) {
                sum -= nums[left++];
            } else if (sum <= M) {
                sum += nums[++right];
            }
        }

        System.out.println(answer);
    }
}
