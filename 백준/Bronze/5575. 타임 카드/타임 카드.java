import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int start = stoi(st.nextToken()) * 3600 + stoi(st.nextToken()) * 60 + stoi(st.nextToken());
            int end = stoi(st.nextToken()) * 3600 + stoi(st.nextToken()) * 60 + stoi(st.nextToken());
            int time = end - start;
            
            System.out.println(time / 3600 + " " + (time % 3600) / 60 + " " + (time % 3600) % 60);
        }
    }
}
