import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int answer;
    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                int num = stoi(st.nextToken());

                board[i][j] = num;
                map.put(num, new int[]{i, j});
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                int num = stoi(st.nextToken());
                answer++;

                int x = map.get(num)[0];
                int y = map.get(num)[1];

                visited[x][y] = true;

                if (isBingo()) {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }

    static boolean isBingo() {
        int bingo = 0;

        for (int i = 0; i < 5; i++) {
            int count = 0;

            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    count++;
                }
            }

            if (count == 5) {
                bingo++;
            }
        }

        for (int i = 0; i < 5; i++) {
            int count = 0;

            for (int j = 0; j < 5; j++) {
                if (visited[j][i]) {
                    count++;
                }
            }

            if (count == 5) {
                bingo++;
            }
        }

        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (visited[i][i]) {
                count++;
            }
        }

        if (count == 5) {
            bingo++;
        }

        count = 0;
        for (int i = 0; i < 5; i++) {
            if (visited[i][4 - i]) {
                count++;
            }
        }

        if (count == 5) {
            bingo++;
        }

        return bingo >= 3;
    }
}
