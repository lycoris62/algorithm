import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[][] scores;
    static boolean[] visited;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        scores = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int score = stoi(st.nextToken());
                scores[i][j] = score;
            }
        }

        // 1. 조합으로 팀멤버 꾸리기
        // 2. 팀멤버대로 점수 계산...반대 팀도 구해야됨
        // 2.1 우선 첫 팀 다 계산하고, visited 처리 안 된거 더하면 될듯
        // 3. 최솟값 찾기

        dfs(0, 0, 0);

        System.out.println(ans);
    }

    static void dfs(int depth, int total, int start) {
        if (depth == N / 2) { // 팀 편성이 완료되면

            int anotherTotal = 0; // 다른 팀의 능력치 합

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    for (int j = 0; j < i; j++) {
                        if (!visited[j]) {
                            anotherTotal += scores[i][j];
                            anotherTotal += scores[j][i];
                        }
                    }
                }
            }

            // 두 팀의 능력치 차 중 최솟값을 저장
            ans = Math.min(ans, Math.abs(total - anotherTotal));
            return;
        }

        int nextTotal = total;

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;

                // 지금까지 방문한 팀원 (우리 팀) 스코어 다 합치기
                for (int j = 0; j < i; j++) {
                    if (visited[j]) { // 우리 팀이라면
                        nextTotal += scores[j][i];
                        nextTotal += scores[i][j];
                    }
                }

                dfs(depth + 1, nextTotal, i + 1);

                visited[i] = false;
                nextTotal = total;
            }
        }
    }
}
