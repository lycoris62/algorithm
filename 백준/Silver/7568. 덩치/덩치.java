import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<Human> li = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            li.add(new Human(stoi(st.nextToken()), stoi(st.nextToken())));
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            Human mainHuman = li.get(i);
            for (int j = 0; j < N; j++) {
                Human subHuman = li.get(j);
                if (mainHuman.height < subHuman.height && mainHuman.weight < subHuman.weight) cnt++;
            }
            sb.append(cnt + " ");
        }
        
        System.out.println(sb);
    }

    static class Human {
        int height, weight;

        public Human(int weight, int height) {
            this.height = height;
            this.weight = weight;
        }
    }
}

