import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] parents;
    static float cost = 0;
    static List<Edge> edgeList;
    static Point[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        points = new Point[N];
        parents = new int[N + 1];
        edgeList = new ArrayList<>();

        make();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(i, x, y);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double weight = distance(points[i], points[j]);
                edgeList.add(new Edge(i, j, weight));
            }
        }
        
        Collections.sort(edgeList);
        
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if (find(edge.start) != find(edge.end)) {
                cost += edge.weight;
                union(edge.start, edge.end);
            }
        }
        System.out.println(String.format("%.2f", cost));
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot > bRoot) parents[aRoot] = bRoot;
        else parents[bRoot] = aRoot;
    }

    static int find(int n) {
        if (n == parents[n]) return n;
        else return parents[n] = find(parents[n]);
    }

    static void make() {
        for (int i = 0; i <= N; i++) parents[i] = i;
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt((Math.pow(p1.x - p2.x, 2)) + Math.pow(p1.y - p2.y, 2));
    }
}

class Point {
    int num;
    double x;
    double y;

    public Point(int num, double x, double y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    double weight;

    public Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight < o.weight) {
            return -1;
        }
        return 1;
    }
}
