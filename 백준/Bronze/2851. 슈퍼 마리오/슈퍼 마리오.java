import java.io.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int answer;
    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            arr[i] = stoi(br.readLine());
        }

        for (int i = 1; i < 10; i++) {
            arr[i] += arr[i - 1];
        }

        for (int i = 0; i < 10; i++) {
            int now = arr[i];

            if (i == 9 && now < 100) {
                answer = now;
                break;
            }

            if (now < 100) {
                continue;
            }

            if (i == 0) {
                answer = arr[i];
                break;
            }

            if (Math.abs(now - 100) > Math.abs(100 - arr[i - 1])) {
                answer = arr[i - 1];
                break;
            }

            answer = arr[i];
            break;
        }

        System.out.println(answer);
    }
}
