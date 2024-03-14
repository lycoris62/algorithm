import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int left, right;
    static int leftAns, rightAns;
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

        Arrays.sort(arr);

        left = leftAns = 0;
        right = rightAns = N - 1;

        // 0에 가장 가까운 용액 -> 0 이상이면서 가장 작은 수 찾기 -> lower bound
        // 가 아니라 투 포인터였음...

        while (left < right) {
            int mid = (left + right) / 2;
            int total = arr[right] + arr[left];

            if (total == 0) { // 0에 가까운 수를 찾는 것이므로 0이면 바로 리턴
                leftAns = left;
                rightAns = right;
                break;
            }

            // 지금까지 찾은 것보다 더 0에 가까우면 각각 용액값 저장
            if (Math.abs(arr[leftAns] + arr[rightAns]) > Math.abs(total)) {
                leftAns = left;
                rightAns = right;
            }

            if (total > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(arr[leftAns] + " " + arr[rightAns]);
    }
}
