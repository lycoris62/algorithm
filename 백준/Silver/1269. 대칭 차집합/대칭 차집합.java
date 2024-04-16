import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int A, B;
    static Set<Integer> setA = new HashSet<>();
    static Set<Integer> setB = new HashSet<>();
    static Set<Integer> temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            setA.add(stoi(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            setB.add(stoi(st.nextToken()));
        }

        temp = new HashSet<>(setA);

        setA.removeAll(setB);
        setB.removeAll(temp);

        System.out.println(setA.size() + setB.size());
    }
}
