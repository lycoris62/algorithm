import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_SIZE = 52;
    static final int OP = 10_007;
    static int N, answer;
    static int[][] combinations = new int[MAX_SIZE + 1][MAX_SIZE + 1];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i <= MAX_SIZE; i++) {
            combinations[i][0] = 1;
        }

        for (int i = 1; i <= MAX_SIZE; i++) {
            for (int j = 1; j <= MAX_SIZE; j++) {
                combinations[i][j] = (combinations[i - 1][j] + combinations[i - 1][j - 1]) % OP;
            }
        }

        for (int i = 1; i <= 13 && N - 4 * i >= 0; i++) {
            if (i % 2 == 1) {
                answer = (answer + combinations[52 - 4 * i][N - 4 * i] * combinations[13][i]) % OP;
            } else {
                answer = (answer - (combinations[52 - 4 * i][N - 4 * i] * combinations[13][i]) % OP + OP) % OP;
            }
        }

        System.out.println(answer);
    }
}
