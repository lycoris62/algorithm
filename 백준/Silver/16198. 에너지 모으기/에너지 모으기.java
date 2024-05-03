import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        List<Integer> list = new ArrayList<>(N);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(stoi(st.nextToken()));
        }

        dfs(0, list);

        System.out.println(answer);
    }

    static void dfs(int total, List<Integer> list) {
        if (list.size() == 2) {
            answer = Math.max(answer, total);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int energy = list.get(i - 1) * list.get(i + 1);
            List<Integer> newList = new ArrayList<>(list);
            newList.remove(i);
            dfs(total + energy, newList);
        }
    }
}
