import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int T, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		T = stoi(st.nextToken());
		while (T-- > 0) {
			M = stoi(br.readLine());
			sb.append(M % 2 == 1 ? M / 2 + 1 : M / 2).append("\n");
			Queue<Integer> minHeap = new PriorityQueue<>();
			Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			int cnt = 0;

			for (int i = 0; i < M / 10 + 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				while (st.hasMoreTokens()) {
					cnt++;
					int x = stoi(st.nextToken());

					if (!maxHeap.isEmpty() && maxHeap.peek() < x) {
						minHeap.add(x);
					} else {
						maxHeap.add(x);
					}

					if (maxHeap.size() - minHeap.size() >= 2) {
						minHeap.add(maxHeap.poll());
					}

					if (minHeap.size() > maxHeap.size()) {
						maxHeap.add(minHeap.poll());
					}

					if (cnt % 2 == 1) {
						sb.append(maxHeap.peek()).append(" ");
					}

					if (cnt % 20 == 0) {
						sb.append("\n");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
