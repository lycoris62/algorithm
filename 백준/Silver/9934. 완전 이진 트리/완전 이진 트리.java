import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<List<Integer>> tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        tree = new ArrayList<>();
        List<Integer> inputList = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            inputList.add(stoi(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>((int) Math.pow(2, i)));
        }

        rec(0, inputList);

        for (List<Integer> ints : tree) {
            for (int x : ints) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void rec(int depth, List<Integer> list) {
        if (list.size() == 3) {
            tree.get(N - 2).add(list.get(1));
            tree.get(N - 1).add(list.get(0));
            tree.get(N - 1).add(list.get(2));
            return;
        }
        
        int halfLength = list.size() / 2;

        tree.get(depth).add(list.get(halfLength));
        list.remove(list.get(halfLength));

        rec(depth + 1, new ArrayList<>(list.subList(0, halfLength)));
        rec(depth + 1, new ArrayList<>(list.subList(halfLength, list.size())));
    }
}
