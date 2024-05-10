import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<String> caseList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    String num = String.valueOf(i * 100 + j * 10 + k);
                    caseList.add(num);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sol(st.nextToken(), stoi(st.nextToken()), stoi(st.nextToken()));
        }

        System.out.println(caseList.size());
    }

    static void sol(String expect, int strike, int ball) {

        List<String> correctList = new LinkedList<>();

        for (String num : caseList) {
            int strikeCount = 0;
            int ballCount = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (num.charAt(i) == expect.charAt(j)) {
                        if (i == j) {
                            strikeCount++;
                        } else {
                            ballCount++;
                        }
                    }
                }
            }

            if (strikeCount == strike && ballCount == ball) {
                correctList.add(num);
            }
        }

        caseList = correctList;
    }
}
