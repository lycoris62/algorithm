import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, cost;
	static Edge[] edges;
	static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
		M = stoi(br.readLine());
		edges = new Edge[M];
		parents = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edges[i] = new Edge(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
		}

		Arrays.sort(edges);

		for (Edge edge : edges) {
			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				cost += edge.cost;
			}
		}

		System.out.println(cost);
    }

	static int find(int x) {
		return parents[x] == x ? x : find(parents[x]);
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

	static class Edge implements Comparable<Edge>{
		int start, end, cost;

		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}
