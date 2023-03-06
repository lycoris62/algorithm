import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>(N);
        while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list.get(K - 1));
    }
}
