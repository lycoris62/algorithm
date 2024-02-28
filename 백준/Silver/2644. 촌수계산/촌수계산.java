import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, start, end;
    static boolean[][] graph;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = stoi(st.nextToken());
        end = stoi(st.nextToken());
        M = stoi(br.readLine());

        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = stoi(st.nextToken());
            int child = stoi(st.nextToken());
            graph[parent][child] = true;
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Person> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new Person(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Person now = q.poll();

            if (now.num == end) {
                return now.count;
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    if (graph[now.num][i] || graph[i][now.num]) {
                        q.add(new Person(i, now.count + 1));
                        visited[i] = true;
                    }
                }
            }
        }

        return -1;
    }
}

class Person {

    int num, count;

    public Person(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
