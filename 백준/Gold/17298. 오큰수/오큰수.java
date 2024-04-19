import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr, answer;
    static Deque<Integer> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];
        answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        // 스택 문제 특) 반대로 생각 해야 함
        // 예제1 기준, 배열은 [3, 5, 2, 7]
        // 3을 기준으로 3보다 큰 가장 큰 왼쪽 수인 5를 생각할 것이 아니라,
        // 5에서 왼쪽에 있는 처음 5보다 작은 수를 가져오기.

        // 스택에는 인덱스를 넣는다. 위에서 5를 기준으로 하면, 오큰수가 5가 되는
        // ㄴ 모든 정답 배열 인덱스에 5를 넣어 주어야 하기 때문.

        // for 문으로 배열을 돌기 -> i는 배열의 인덱스.
        // 만약 스택이 비어있다면 스택에 인덱스 넣기.
        // 스택이 있고, 스택의 상단을 확인 후, 현재 값보다 낮으면
        // ㄴ 스택에서 pop 후 그 인덱스는 현재 값으로 answer에 채우기.

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] < arr[i]) {
                answer[stack.pollLast()] = arr[i];
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pollLast()] = -1;
        }

        for (int x : answer) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}