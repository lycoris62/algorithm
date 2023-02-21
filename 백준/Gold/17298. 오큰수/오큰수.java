import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] li;
    static Stack<Integer> stack;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        stack = new Stack<>();
        ans = new int[N];
        li = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) li[i] = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && li[stack.peek()] < li[i]) ans[stack.pop()] = li[i];
            stack.push(i);
        }

        while (!stack.isEmpty()) ans[stack.pop()] = -1;

        for (int x : ans) bw.write(x + " ");
        bw.close();
    }
}
