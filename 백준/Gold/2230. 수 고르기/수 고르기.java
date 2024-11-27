import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer = Integer.MAX_VALUE;
    static int[] arr;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = stoi(br.readLine());
        }

        Arrays.sort(arr);

        int end = 0;
        for (int start = 0; start < N; start++) {
            while (end < N && (arr[end] - arr[start] < M)) {
                end++;
            }

            if (end == N) { // 오름차순 정렬되어 있으므로 start가 0이고 end가 N-1일 때 최대차
                break;
            }

            // 조건으로 항상 차이가 M 이상 나는 두 수를 구할 수 있으므로 위의 break 문에 의해 무시되지 않음
            answer = Math.min(answer, arr[end] - arr[start]); // 10억 - (-10억) = 20억 < int 최댓값
        }

        System.out.println(answer);
    }
}
