import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, res = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        board = new int[101][101];
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());

            for (int i = y; i < y + 10; i++) {
                if (y > 100) {
                    break;
                }
                for (int j = x; j < x + 10; j++) {
                    if (x > 100) {
                        break;
                    }
                    board[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (board[i][j] == 1) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}
