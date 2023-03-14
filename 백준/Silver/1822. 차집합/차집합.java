import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static Set<Integer> setA, setB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        setA = new TreeSet<>();
        setB = new TreeSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) setA.add(stoi(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) setB.add(stoi(st.nextToken()));

        setA.removeAll(setB);

        for (int x : setA) sb.append(x + " ");
        
        System.out.println(setA.size());
        if (!setA.isEmpty()) System.out.println(sb);
    }
}
