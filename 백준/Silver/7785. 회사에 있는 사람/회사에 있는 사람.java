import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Map<String, Boolean> map = new HashMap<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String person = st.nextToken();
            boolean isEnter = st.nextToken().equals("enter");

            if (isEnter) {
                map.put(person, true);
            } else {
                map.remove(person);
            }
        }

        map.keySet()
            .stream()
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);
    }
}
