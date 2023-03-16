import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static Map<Character, Double> map = new HashMap<>();
    static Stack<Double> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        String str = br.readLine();
        for (int i = 0; i < N; i++) map.put((char) ('A' + i), Double.parseDouble(br.readLine()));
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            double a, b;
            switch (ch) {
                case '+':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case '-':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case '*':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case '/':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(map.get(ch));
                    break;
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
