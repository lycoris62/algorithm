import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int R, C, T, U, D;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        T = stoi(st.nextToken());

        graph = new int[T + 1][R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int x = stoi(st.nextToken());
                if (x == -1) {
                    if (U == 0) {
                        U = i;
                    } else {
                        D = i;
                    }
                }
                graph[0][i][j] = x;
            }
        }

        // 1. T 가 0 ~ T-1 까지 BFS 반복
        // 매 BFS 에서는 t + 1 의 미세먼지를 저장.
        // 미세먼지 리스트를 돌며 t + 1 의 미세먼지를 += 해서 저장
        // 그 다음 공기청정기가 미세먼지를 한 칸씩 이동
        // 이를 T 번 반복 후, graph[T] 의 미세먼지의 총합 구하기.

        // 미세먼지 리스트는 입력 받을 때 따로 저장. -> 아니, 매 t 마다 수집
        // 공기청정기 위치는 입력 받을 때 따로 상, 하 구분하여 저장

        for (int i = 0; i < T; i++) {
            bfs(i);
        }

        int totalDust = 0;
        for (int[] row : graph[T]) {
            for (int x : row) {
                totalDust += x;
            }
        }

        System.out.println(totalDust);
    }

    static void bfs(int t) {
        // 1. 미세먼지 수집
        // 2. t + 1 에 미세먼지 확산 시키기
        // 3. 공기청정기 정화
        // 4. 종료

        Queue<Node> q = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[t][i][j] > 0) {
                    q.add(new Node(i, j, graph[t][i][j]));
                }
            }
        }

        // 미세먼지 확산
        while (!q.isEmpty()) {
            Node now = q.poll();

            // 상하좌우 확산 가능한 공간 개수 세기
            // 가능하다면 t + 1 에 5등분한 먼지를 += 하기
            // 상하좌우를 다 돌고, 개수만큼 빼고 남은 먼지는 현재 위치에 두기.

            int cnt = 0;
            int miniDust = now.dust / 5;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < R) && (0 <= ny && ny < C) && (ny != 0 || (nx != U && nx != D))) {
                    cnt++;
                    graph[t + 1][nx][ny] += miniDust;
                }
            }

            graph[t + 1][now.x][now.y] += now.dust - cnt * miniDust;
        }

        // 공기청정기 정화

        // 왼쪽 위 -> 공기청정기 상반부로 먼지 이동
        for (int i = U - 1; i > 0; i--) {
            graph[t + 1][i][0] = graph[t + 1][i - 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            graph[t + 1][0][i] = graph[t + 1][0][i + 1];
        }

        for (int i = 0; i < U; i++) {
            graph[t + 1][i][C - 1] = graph[t + 1][i + 1][C - 1];
        }

        for (int i = C - 1; i > 0; i--) {
            graph[t + 1][U][i] = graph[t + 1][U][i - 1];
        }

        for (int i = D + 1; i < R - 1; i++) {
            graph[t + 1][i][0] = graph[t + 1][i + 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            graph[t + 1][R - 1][i] = graph[t + 1][R - 1][i + 1];
        }

        for (int i = R - 1; i > D; i--) {
            graph[t + 1][i][C - 1] = graph[t + 1][i - 1][C - 1];
        }

        for (int i = C - 1; i > 0; i--) {
            graph[t + 1][D][i] = graph[t + 1][D][i - 1];
        }
    }

    static class Node {

        int x, y, dust;

        public Node(int x, int y, int dust) {
            this.x = x;
            this.y = y;
            this.dust = dust;
        }
    }
}
