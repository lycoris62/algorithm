import java.io.*;
import java.util.*;

public class Main {

	static Stack<Character> st = new Stack<>();
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if ('A' <= c && c <= 'Z') {
				sb.append(c);
				continue;
			}
			
			if (c == '(')
				st.push(c);
			else if (c == ')') {
				while (!st.isEmpty()) {
					char pop = st.pop();
					if (pop == '(')
						break;
					sb.append(pop);
				}
			} else if (c == '/' || c == '*') {
				while (!st.isEmpty() && st.peek() != '(' && (st.peek() == '*' || st.peek() == '/')) {
					sb.append(st.pop());
				}
				st.push(c);
			} else {
				while (!st.isEmpty() && st.peek() != '(') {
					sb.append(st.pop());
				}
				st.push(c);
			}
		}

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		System.out.println(sb);
    }
}
