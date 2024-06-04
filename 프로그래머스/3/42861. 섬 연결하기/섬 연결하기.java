import java.util.*;

class Solution {

    int answer = 0;
    int[] parent;

    public int find(int a) {
        return parent[a] == a ? a : (parent[a] = find(parent[a]));
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    public int solution(int n, int[][] costs) {

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }

        return answer;
    }
}
