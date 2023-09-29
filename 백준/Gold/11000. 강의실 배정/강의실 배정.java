import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N;
	static List<Lecture> lectures = new ArrayList<>();
	static Queue<Integer> rooms = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lectures.add(new Lecture(stoi(st.nextToken()), stoi(st.nextToken())));
		}

		Collections.sort(lectures);

		for (Lecture lecture : lectures) {
			if (!rooms.isEmpty() && rooms.peek() <= lecture.start) {
				rooms.poll();
			}

			rooms.add(lecture.end);
		}

		System.out.println(rooms.size());
	}

	static class Lecture implements Comparable<Lecture> {
		int start, end;

		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			return this.start == o.start
				? Integer.compare(this.end, o.end)
				: Integer.compare(this.start, o.start);
		}
	}
}
