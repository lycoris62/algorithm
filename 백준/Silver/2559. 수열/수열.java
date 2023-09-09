import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, K, res = Integer.MIN_VALUE / 2;
	static int[] sums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		sums = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			sums[i] = stoi(st.nextToken()) + sums[i - 1];
		}

		for (int i = K; i <= N; i++) {
			int gap = sums[i] - sums[i - K];
			res = Math.max(res, gap);
		}

		System.out.println(res);
	}
}
