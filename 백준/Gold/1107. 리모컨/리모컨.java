import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	static int N, M, channel = 100;
	static List<Integer> buttons = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		IntStream.range(0, 10).forEach(i -> buttons.add(i));
		for (int i = 0; i < M; i++) {
			buttons.remove(Integer.valueOf(sc.nextInt()));
		}

		dfs(0, 0);
		int buttonClicks = String.valueOf(channel).length() + Math.abs(N - channel);
		System.out.println(Math.min(Math.abs(N - 100), buttonClicks));
	}

	static void dfs(int depth, int total) {

		if (depth > 0) {
			int prevClicks = Math.abs(N - channel) + String.valueOf(channel).length();
			int nowClicks = Math.abs(N - total) + String.valueOf(total).length();

			if (prevClicks > nowClicks) {
				channel = total;
			}
		}

		if (depth == 6) {
			return;
		}

		for (Integer button : buttons) {
			dfs(depth + 1, total * 10 + button);
		}
	}
}
