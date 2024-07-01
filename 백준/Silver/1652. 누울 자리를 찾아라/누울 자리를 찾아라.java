import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, row, col;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            int rowCount = 0, colCount = 0;

            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    rowCount++;
                }
                if (board[i][j] == 'X' || (j == N - 1)) {
                    if (rowCount >= 2) {
                        row++;
                    }
                    rowCount = 0;
                }

                if (board[j][i] == '.') {
                    colCount++;
                }
                if (board[j][i] == 'X' || (j == N - 1)) {
                    if (colCount >= 2) {
                        col++;
                    }
                    colCount = 0;
                }
            }
        }

        System.out.println(row + " " + col);
    }
}