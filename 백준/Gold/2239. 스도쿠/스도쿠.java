import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] board;
    static List<int[]> li;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        li = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = str.charAt(j) - '0';
                board[i][j] = num;
                if (num == 0) li.add(new int[]{i, j});
            }
        }
        bt(0);
    }

    static void bt(int cnt) {
        if (li.size() == cnt) {
            print();
            return;
        }
        int n = li.get(cnt)[0];
        int m = li.get(cnt)[1];

        for (int i = 1; i <= 9; i++) {
            if (isRight(n, m, i)) {
                board[n][m] = i;
                bt(cnt + 1);
                board[n][m] = 0;
            }
        }
    }

    static boolean isRight(int n, int m, int x) {
        for (int i = 0; i < 9; i++) {
            if (i == m) continue;
            if (board[n][i] == x) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (i == n) continue;
            if (board[i][m] == x) return false;
        }

        int rowStart = (n / 3) * 3;
        int colStart = (m / 3) * 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (i == n && j == m) continue;
                if (board[i][j] == x) return false;
            }
        }

        return true;
    }

    static void print() {
        for (int[] row : board) {
            for (int i : row) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.exit(0);
    }
}
