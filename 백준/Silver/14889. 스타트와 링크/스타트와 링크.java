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
        input();
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void input() throws IOException {
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
    }

    static void dfs(int depth, int start) {
        if (depth == N / 2) { // 팀 편성이 완료되면
            diff(); // 팀 스코어 차이를 계산 후 최솟값 저장 
            return;
        }

        for (int i = start; i < N; i++) { // 조합 -> 순서 상관X 
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int teamStartScore = 0;
        int teamLinkScore = 0;

        for (int nowPerson = 0; nowPerson < N; nowPerson++) {
            boolean isNowTeamStart = visited[nowPerson];

            for (int prevPerson = 0; prevPerson < nowPerson; prevPerson++) {
                boolean isPrevTeamStart = visited[prevPerson];

                if (isNowTeamStart == isPrevTeamStart) {
                    int tempScore = scores[nowPerson][prevPerson] + scores[prevPerson][nowPerson];

                    if (isNowTeamStart) {
                        teamStartScore += tempScore;
                    } else {
                        teamLinkScore += tempScore;
                    }
                }
            }
        }

        int scoreDiff = Math.abs(teamStartScore - teamLinkScore);
        ans = Math.min(ans, scoreDiff);
    }
}
