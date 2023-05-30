import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static char[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' ');
        }
        rec(N, 0, 0);
        for (char[] chars : board) {
            for (char ch : chars) {
                sb.append(ch);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rec(int len, int r, int c) {
        if (len == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[r + i][c + j] = '*';
                }
            }
            board[r + 1][c + 1] = ' ';
            return;
        }
        
        len /= 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                rec(len, r + len * i, c + len * j);
            }
        }
    }
}
