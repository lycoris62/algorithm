import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> minHeap = new PriorityQueue<>(); // 중간값 초과하는 최소힙
	static Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 중간값 이하인 최대힙

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());

		for (int i = 0; i < N; i++) {
			int x = stoi(br.readLine());

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

			sb.append(maxHeap.peek()).append("\n");
		}

		System.out.println(sb);
	}
}
