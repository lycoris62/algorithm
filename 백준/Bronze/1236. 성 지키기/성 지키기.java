import java.io.*;
import java.util.*;

public class Main {

    static int N, M, rowCount, colCount;
    static char[][] board;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (char[] row : board) {
            boolean isNotX = true;
            for (char ch : row) {
                if (ch == 'X') {
                    isNotX = false;
                    break;
                }
            }

            if (isNotX) {
                rowCount++;
            }
        }

        for (int i = 0; i < M; i++) {
            boolean isNotX = true;
            for (int j = 0; j < N; j++) {
                char ch = board[j][i];

                if (ch == 'X') {
                    isNotX = false;
                    break;
                }
            }

            if (isNotX) {
                colCount++;
            }
        }

        System.out.println(Math.max(rowCount, colCount));
    }
}
