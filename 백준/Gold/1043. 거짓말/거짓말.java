import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, answer;
    static int[] parents;
    static boolean[] isKnown;
    static boolean[] visited;
    static List<Set<Integer>> parties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        parents = new int[N + 1];
        isKnown = new boolean[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        while (n-- > 0) {
            int knownPerson = stoi(st.nextToken());
            isKnown[knownPerson] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            parties.add(new HashSet<>());

            int partyPeople = stoi(st.nextToken());

            int[] people = new int[partyPeople];
            for (int j = 0; j < partyPeople; j++) {
                people[j] = stoi(st.nextToken());
            }

            if (partyPeople <= 1) {
                parties.get(i).add(people[0]);
                continue;
            }

            for (int j = 0; j < partyPeople - 1; j++) {
                int a = find(people[j]);
                int b = find(people[j + 1]);
                if (a != b) {
                    union(a, b);
                }

                parties.get(i).add(a);
                parties.get(i).add(b);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isKnown[i] && !visited[i]) {
                int root = find(i);

                for (int j = 1; j <= N; j++) {
                    if (find(j) == root) {
                        isKnown[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        for (Set<Integer> party : parties) {
            boolean flag = false;

            for (Integer person : party) {
                if (isKnown[person]) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent != bParent) {
            parents[bParent] = aParent;
        }
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}
