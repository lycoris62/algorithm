import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int level = 0;
	static Stack<Character> st = new Stack<>();
	static int[] arr = new int[31];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(' || c == '[') {
				st.push(c);
				level++;
				continue;
			}

			int x = 0;
			
			if (c == ')') {
				if (st.isEmpty() || st.peek() != '(') {
					System.out.println(0);
					return;
				}

				level--;

				x = 2;
				if (arr[level + 1] != 0) {
					x = arr[level + 1] * 2;
					arr[level + 1] = 0;
				}
			}

			if (c == ']') {
				if (st.isEmpty() || st.peek() != '[') {
					System.out.println(0);
					return;
				}

				level--;

				x = 3;
				if (arr[level + 1] != 0) {
					x = arr[level + 1] * 3;
					arr[level + 1] = 0;
				}
			}

			st.pop();

			arr[level] = arr[level] != 0 ? arr[level] + x : x;
			
		}

		System.out.println(arr[0]);
	}
}
