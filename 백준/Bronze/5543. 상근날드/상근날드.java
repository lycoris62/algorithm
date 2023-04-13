import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int[] hams = new int[3], waters = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) hams[i] = stoi(br.readLine());
        for (int i = 0; i < 2; i++) waters[i] = stoi(br.readLine());
        System.out.println(Arrays.stream(hams).min().getAsInt() + Arrays.stream(waters).min().getAsInt() - 50);
    }
}
