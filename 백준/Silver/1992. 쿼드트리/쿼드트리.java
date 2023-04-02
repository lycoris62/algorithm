import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken()); // 가로 길이
        map = new int[N][N]; // 영상의 데이터를 나타내는 2차원 배열

        for (int i = 0; i < N; i++) {
            String str = br.readLine(); // 한줄 입력 받고

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0'; // char 형태로 받으니 - '0' 해줘야 int 형태로 바꿀 수 있음
            }
        }

        rec(0, 0, N); // 0, 0 부터 시작해서 분할정복

        System.out.println(sb); // 출력
    }

    static void rec(int n, int m, int length) { // 분할정복
        int check = map[n][m];

        Outer:
        // 자바에서는 이중 for문일 때 외부 포문을 라벨링해서 break 할 수 있음
        for (int i = n; i < n + length; i++) { // n부터 n + length 까지
            Inner:
            // 내부도 라벨링할 수 있지만 사용하지 않음
            for (int j = m; j < m + length; j++) { // m부터 m + length 까지
                if (map[i][j] != check) { // 하나라도 다르면
                    check = -1; // check를 -1로 바꿔서 다시 재귀함수 호출할 수 있도록 체크해두기
                    break Outer; // 외부 포문 break
                }
            }
        }

        if (check == -1) { // 만약 하나라도 다르면
            // 4개로 나눠서 재귀함수 호출
            sb.append("(");
            length = length / 2;
            rec(n, m, length);
            rec(n, m + length, length);
            rec(n + length, m, length);
            rec(n + length, m + length, length);
            sb.append(")");
        } else { // 모두 같으면
            // 0이면 0, 1이면 1 출력
            sb.append(check);
        }
    }
}
