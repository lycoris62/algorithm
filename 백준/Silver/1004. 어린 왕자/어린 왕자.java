import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N, X1, Y1, X2, Y2;
    static List<Planet> planets;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T --> 0) {
            planets = new ArrayList<>();
            int ans = 0;

            st = new StringTokenizer(br.readLine());
            X1 = stoi(st.nextToken());
            Y1 = stoi(st.nextToken());
            X2 = stoi(st.nextToken());
            Y2 = stoi(st.nextToken());

            N = stoi(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                planets.add(new Planet(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())));
            }

            for (Planet planet : planets) {
                if (planet.isInner(X1, Y1) ^ planet.isInner(X2, Y2)) {
                    ans++;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}

class Planet {
    int cx, cy, r;

    public Planet(int cx, int cy, int r) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    public boolean isInner(int x, int y) {
        double length = Math.sqrt(Math.pow(x - cx, 2) + Math.pow(y - cy, 2));
        return length <= r;
    }
}