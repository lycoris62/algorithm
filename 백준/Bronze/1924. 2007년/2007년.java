import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int month = stoi(st.nextToken());
        int day = stoi(st.nextToken());

        for (int i = 0; i < month - 1; i++) day += days[i];

        String ans = dayOfWeek[day % dayOfWeek.length];
        System.out.println(ans);
    }
}