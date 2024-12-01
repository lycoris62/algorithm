import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, peopleCount = 1;
    static String seats;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        seats = br.readLine();

        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == 'L') {
                i++;
            }
            peopleCount++;
        }

        System.out.println(Math.min(N, peopleCount));
    }
}
