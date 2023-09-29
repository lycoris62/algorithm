import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = stoi(st.nextToken());
		N = stoi(st.nextToken());
		K = stoi(br.readLine());

		List<Rectangle> list = new ArrayList<>();
		list.add(new Rectangle(0, N, 0, M));

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int std = stoi(st.nextToken());
			int line = stoi(st.nextToken());
			List<Rectangle> temp = new ArrayList<>();

			if (std == 0) {
				for (Rectangle rect : list) {
					if (rect.x0 < line && line < rect.x1) {
						temp.add(new Rectangle(rect.x0, line, rect.y0, rect.y1));
						temp.add(new Rectangle(line, rect.x1, rect.y0, rect.y1));
					} else {
						temp.add(rect);
					}
				}
			} else {
				for (Rectangle rect : list) {
					if (rect.y0 < line && line < rect.y1) {
						temp.add(new Rectangle(rect.x0, rect.x1, rect.y0, line));
						temp.add(new Rectangle(rect.x0, rect.x1, line, rect.y1));
					} else {
						temp.add(rect);
					}
				}
			}

			list = temp;
		}

		Collections.sort(list);
		System.out.println(list.get(0).getArea());
    }

	static class Rectangle implements Comparable<Rectangle> {

		int x0, x1, y0, y1;

		public Rectangle(int x0, int x1, int y0, int y1) {
			this.x0 = x0;
			this.x1 = x1;
			this.y0 = y0;
			this.y1 = y1;
		}

		public int getArea() {
			return Math.abs(x1 - x0) * Math.abs(y1 - y0);
		}

		@Override
		public int compareTo(Rectangle o) {
			return Integer.compare(o.getArea(), getArea());
		}
	}
}
