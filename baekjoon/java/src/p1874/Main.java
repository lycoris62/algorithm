package p1874;

import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static Stack<Integer> stack = new Stack<>();
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        while (N-- > 0) {
            int x = stoi(br.readLine());
            if (cnt <= x) {
                for (int i = cnt; i <= x; i++) {
                    stack.push(i);
                    cnt++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.isEmpty() || stack.peek() < x) {
                    System.out.println("NO");
                    return;
                } else {
                    boolean isSearch = false;
                    while (!stack.isEmpty()) {
                        int peek = stack.pop();
                        sb.append("-\n");
                        if (peek == x) {
                            isSearch = true;
                            break;
                        }
                    }
                    if (!isSearch) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
