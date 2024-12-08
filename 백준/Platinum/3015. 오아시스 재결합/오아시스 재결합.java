import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long answer;
    static int[] heights;
    static Stack<Height> stack = new Stack<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = stoi(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek().height < heights[i]) {
                answer += stack.pop().count;
            }

            if (stack.isEmpty()) {
                stack.push(new Height(heights[i], 1));
                continue;
            }

            if (stack.peek().height > heights[i]) {
                stack.push(new Height(heights[i], 1));
                answer++;
                continue;
            }

            answer += stack.peek().count++;
            if (stack.size() > 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class Height {

        int height, count;

        public Height(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
}
