import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] board; // 스도쿠 판을 2차원 배열로 구현
    static List<int[]> zeroList; // 숫자가 0인 부분을 따로 (x, y) 좌표로 모아두는 배열 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9]; // 스도쿠 판을 2차원 배열로 구현
        zeroList = new ArrayList<>(); // 숫자가 0인 부분을 따로 (x, y) 좌표로 모아두는 배열 리스트

        // 입력으로 주어지는 스도쿠판을 돌며 board 배열을 채우고
        // 0인 칸만 따로 그 좌표를 zeroList에 모아둔다
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = str.charAt(j) - '0';
                board[i][j] = num;

                if (num == 0)
                    zeroList.add(new int[]{i, j});
            }
        }

        // 백트래킹으로 모든 zeroList의 값을 1~9중에 대입해보고
        // 스도쿠가 처음으로 완성되면 (= 사전식으로 앞서면) 출력
        bt(0);
    }

    static void bt(int depth) {
        if (zeroList.size() == depth) { // 0인 칸을 전부 채우면
            // 출력 후
            for (int[] row : board) {
                for (int i : row) {
                    System.out.print(i);
                }
                System.out.println();
            }

            System.exit(0); // 이후 더 돌지 않고 프로그램 종료
        }

        int n = zeroList.get(depth)[0]; // n행
        int m = zeroList.get(depth)[1]; // m열

        for (int i = 1; i <= 9; i++) { // 0인 칸을 1~9까지 골라서
            if (isRight(n, m, i)) { // 그 숫자가 가로, 세로, 3*3칸이 이상 없으면
                board[n][m] = i; // 그 칸에 그 숫자 입력 후
                bt(depth + 1); // 다음 0인 칸을 돌기
                // 다시 돌아왔다는 것은 이 숫자가 스도쿠가 안 만들어진다는 뜻이므로 0으로 되돌리기
                board[n][m] = 0;
            }
        }
    }

    // n행 m열의 칸에 숫자 x를 넣으면 스도쿠에 이상이 없는지 체크하는 함수
    static boolean isRight(int n, int m, int x) {
        for (int i = 0; i < 9; i++) { // n행 에서 이상이 없는지 체크
            if (i == m) continue; // 입력할 칸은 넘어가기
            if (board[n][i] == x) return false; // n행 중 하나라도 x와 같은 값이 있으면 스도쿠 실패
        }

        for (int i = 0; i < 9; i++) { // m열에서 이상이 없는지 체크
            if (i == n) continue; // 입력할 칸은 넘어가기
            if (board[i][m] == x) return false; // m열 중 하나라도 x와 같은 값이 있으면 스도쿠 실패
        }

        // 3*3 칸의 시작 행과 열 계산
        int rowStart = (n / 3) * 3;
        int colStart = (m / 3) * 3;

        for (int i = rowStart; i < rowStart + 3; i++) { // 시작 행 ~ +3행
            for (int j = colStart; j < colStart + 3; j++) { // 시작 열 ~ +3열
                if (i == n && j == m) continue; // 입력할 칸은 넘어가기
                if (board[i][j] == x) return false; // 3*3칸 중 x와 같은 값이 있으면 스도쿠 실패
            }
        }

        return true; // 위를 전부 거쳐도 이상 없으면 스도쿠 가능
    }
}
