import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
	static int[] parents;
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		parents = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}

		Arrays.sort(parents);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			boolean isUnion = stoi(st.nextToken()) == 0;
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());

			if (isUnion) {
				union(a, b);
			} else {
				String out = find(a) != find(b) ? "NO" : "YES";
				sb.append(out).append("\n");
			}
		}

		System.out.println(sb);
    }

	static int find(int x) {
		return parents[x] == x ? x : (parents[x] = find(parents[x]));
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot < bRoot) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
		}
	}
}
