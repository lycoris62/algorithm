import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int M;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());

        while (M-- > 0) {
            String[] arr = br.readLine().split(" ");

            String op = arr[0];
            int x;

            switch (op) {
                case "all":
                    set.clear();
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;

                case "empty":
                    set.clear();
                    break;

                case "add":
                    x = stoi(arr[1]);
                    set.add(x);
                    break;

                case "remove":
                    x = stoi(arr[1]);
                    set.remove(x);
                    break;

                case "toggle":
                    x = stoi(arr[1]);
                    if (set.contains(x)) {
                        set.remove(x);
                    } else {
                        set.add(x);
                    }
                    break;

                case "check":
                    x = stoi(arr[1]);
                    sb.append(set.contains(x) ? 1 : 0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
