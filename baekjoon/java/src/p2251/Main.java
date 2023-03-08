package p2251;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int A, B, C;
    static List<Integer> li = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        C = stoi(st.nextToken());

        bfs();

        Collections.sort(li);

        System.out.println(li.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    static class Bottle {
        int a, b, c;

        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static void bfs() {
        Queue<Bottle> q = new LinkedList<>();
        boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];

        q.add(new Bottle(0, 0, C));

        while (!q.isEmpty()) {
            Bottle bottle = q.poll();

            if (visited[bottle.a][bottle.b][bottle.c]) continue;

            if (bottle.a == 0) li.add(bottle.c);

            visited[bottle.a][bottle.b][bottle.c] = true;

            // B->A
            if (bottle.a + bottle.b <= A) q.add(new Bottle(bottle.a + bottle.b, 0, bottle.c));
            else q.add(new Bottle(A, bottle.a + bottle.b - A, bottle.c));
            // C->A
            if (bottle.a + bottle.c <= A) q.add(new Bottle(bottle.a + bottle.c, bottle.b, 0));
            else q.add(new Bottle(A, bottle.b, bottle.a + bottle.c - A));
            // A->B
            if (bottle.a + bottle.b <= B) q.add(new Bottle(0, bottle.a + bottle.b, bottle.c));
            else q.add(new Bottle(bottle.a + bottle.b - B, B, bottle.c));
            // C->B
            if (bottle.c + bottle.b <= B) q.add(new Bottle(bottle.a, bottle.c + bottle.b, 0));
            else q.add(new Bottle(bottle.a, B, bottle.c + bottle.b - B));
            // A->C
            if (bottle.a + bottle.c <= C) q.add(new Bottle(0, bottle.b, bottle.a + bottle.c));
            else q.add(new Bottle(bottle.a + bottle.c - A, bottle.b, C));
            // B->C
            if (bottle.c + bottle.b <= C) q.add(new Bottle(bottle.a, 0, bottle.c + bottle.b));
            else q.add(new Bottle(bottle.a, bottle.c + bottle.b - C, C));

        }
    }
}

