import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, leftIdx, leftAnswerIdx, rightIdx, rightAnswerIdx, minGap;
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

        leftIdx = leftAnswerIdx = 0;
        rightIdx = rightAnswerIdx = N - 1;
        minGap = Integer.MAX_VALUE;

        while (leftIdx < rightIdx) {
            int nowSum = arr[rightIdx] + arr[leftIdx];
            int nowGap = Math.abs(nowSum);

            if (nowGap < minGap) {
                minGap = nowGap;
                leftAnswerIdx = leftIdx;
                rightAnswerIdx = rightIdx;
            }

            if (nowSum > 0) {
                rightIdx--;
            } else {
                leftIdx++;
            }
        }

        System.out.println(arr[leftAnswerIdx] + " " + arr[rightAnswerIdx]);
    }
}
