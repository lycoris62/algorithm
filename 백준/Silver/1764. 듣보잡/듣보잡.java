import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static Set<String> set = new HashSet<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (String name : list) {
            System.out.println(name);
        }
    }
}
