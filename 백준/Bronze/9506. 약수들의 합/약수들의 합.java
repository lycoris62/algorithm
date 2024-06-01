import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            N = stoi(br.readLine());
            if (N == -1) {
                break;
            }

            List<Integer> divisors = getDivisors();

            if (divisors.isEmpty()) {
                sb.append(N).append(" is NOT perfect.").append("\n");
                continue;
            }

            sb.append(N).append(" = ");

            for (int i = 0; i < divisors.size() - 1; i++) {
                sb.append(divisors.get(i)).append(" + ");
            }

            sb.append(divisors.get(divisors.size() - 1)).append("\n");
        }

        System.out.println(sb);
    }

    static List<Integer> getDivisors() {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                list.add(i);
            }
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();

        return sum == N ? list : List.of();
    }
}

