import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int N;
    static final int MAX_SIZE = 1_000_001;
    static boolean[] visited = new boolean[MAX_SIZE];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getPrimes();

        while (true) {
//            N = sc.nextInt();
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            sol();
        }

        System.out.println(sb);
    }

    static void getPrimes() {
        visited[0] = visited[1] = true;
        for (int i = 2; i < MAX_SIZE; i++) {
            if (visited[i]) continue;

            for (int j = i + i; j < MAX_SIZE; j += i) {
                visited[j] = true;
            }
        }
    }

    static void sol() {
        for (int i = 2; i <= N / 2; i++) {
            if (!visited[i] && !visited[N - i]) {
//                sb.append(String.format("%d = %d + %d\n", N, i, N - i));
                sb.append(N).append(" = ").append(i).append(" + ").append(N - i).append("\n");
                return;
            }
        }
        sb.append("Goldbach's conjecture is wrong.\n");
    }
}
