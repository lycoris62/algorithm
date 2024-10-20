import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, J, answer;
    static int start = 1, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        J = stoi(br.readLine());

        end = M;

        for (int i = 0; i < J; i++) {
            int x = stoi(br.readLine());

            if (start <= x && x <= end) {
                continue;
            }

            if (x < start) {
                answer += start - x;
                start = x;
                end = x + M - 1;
            } else {
                answer += x - end;
                end = x;
                start = x - M + 1;
            }
        }

        System.out.println(answer);
    }
}
