import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] birth = new int[3];
        int[] now = new int[3];

        for (int i = 0; i < 3; i++) {
            birth[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            now[i] = stoi(st.nextToken());
        }

        int age = now[0] - birth[0];
        if (now[1] < birth[1]) {
            age--;
        } else if (now[1] == birth[1]) {
            if (now[2] < birth[2]) {
                age--;
            }
        }
        
        System.out.println(age);
        System.out.println(now[0] - birth[0] + 1);
        System.out.println(now[0] - birth[0]);
    }
}
