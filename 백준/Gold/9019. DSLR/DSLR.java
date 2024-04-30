import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, A, B;
    static String[] command = new String[10_000]; // 0-9999
    static boolean[] visited = new boolean[10_000]; // 0-9999
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // BFS.
        // 1. 현재 레지스터 값을 가지고 있어야 함. -> 문자열로 전달 후, 처리 시 정수 변환
        // 2. 현재까지 수행한 명령어 리스트를 가지고 있어야 함. -> 리스트로 전달

        T = stoi(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = stoi(st.nextToken());
            B = stoi(st.nextToken());

            bfs(A);
        }

        System.out.println(sb);
    }

    static void bfs(int a) {
        Arrays.fill(command, "");
        Arrays.fill(visited, false);
        q = new ArrayDeque<>();
        q.add(a);
        visited[a] = true;

        while (!q.isEmpty() && !visited[B]) {
            int now = q.poll();

            int D = (2 * now) % 10_000;
            int S = now == 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!visited[D]) {
                q.add(D);
                visited[D] = true;
                command[D] = command[now] + "D";
            }
            if (!visited[S]) {
                q.add(S);
                visited[S] = true;
                command[S] = command[now] + "S";
            }
            if (!visited[L]) {
                q.add(L);
                visited[L] = true;
                command[L] = command[now] + "L";
            }
            if (!visited[R]) {
                q.add(R);
                visited[R] = true;
                command[R] = command[now] + "R";
            }
        }

        sb.append(command[B]).append("\n");
    }
}
