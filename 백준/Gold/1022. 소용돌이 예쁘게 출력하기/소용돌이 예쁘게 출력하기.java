import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int R1, C1, R2, C2;
    static int max;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R1 = stoi(st.nextToken());
        C1 = stoi(st.nextToken());
        R2 = stoi(st.nextToken());
        C2 = stoi(st.nextToken());

        board = new int[R2 - R1 + 1][C2 - C1 + 1];

        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                board[i - R1][j - C1] = getValue(i, j);
                max = Math.max(max, board[i - R1][j - C1]);
            }
        }

        int maxLen = String.valueOf(max).length();
        String format = "%" + maxLen + "d";

        for (int i = 0; i <= R2 - R1; i++) {
            for (int j = 0; j <= C2 - C1; j++) {
                sb.append(String.format(format, board[i][j])).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int getValue(int row, int col) {
        int level = Math.max(Math.abs(row), Math.abs(col));
        int minValue = (int) Math.pow(2 * level - 1, 2) + 1;

        if (row == level) {
            return minValue + 7 * level + col - 1;
        }
        if (col == -level) {
            return minValue + 5 * level + row - 1;
        }
        if (row == -level) {
            return minValue + 3 * level - col - 1;
        }
        return minValue + level - row - 1;
    }
}
