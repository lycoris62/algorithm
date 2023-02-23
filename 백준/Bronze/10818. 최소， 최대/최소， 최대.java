import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<Integer> li;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        li = new ArrayList<>(N);
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) li.add(stoi(st.nextToken()));
        System.out.printf("%d %d", li.stream().min(Integer::compareTo).get(), li.stream().max(Integer::compareTo).get());
    }
}
