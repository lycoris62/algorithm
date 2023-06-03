import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int R, C, res = 0;
    static char[][] graph;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Map<Character, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = row.charAt(j);
            }
        }
        
        dfs(0, 0, 0);

        System.out.println(res);
    }

    static void dfs(int depth, int r, int c) {
        depth++;
        map.put(graph[r][c], true);
        res = Math.max(res, depth);

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if ((0 <= nr && nr < R) && (0 <= nc && nc < C) && (!map.getOrDefault(graph[nr][nc], false))) {
                dfs(depth, nr, nc);
                map.put(graph[nr][nc], false);
            }
        }
    }
}
