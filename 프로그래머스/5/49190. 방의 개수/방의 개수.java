import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {

    int cnt = 0;
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    Map<Pair, List<Pair>> visited = new HashMap<>();

    public int solution(int[] arrows) {

        Pair pointHC = new Pair(0, 0);

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) {

                Pair newPointHC = new Pair(pointHC.x + dx[arrow], pointHC.y + dy[arrow]);

                if (!visited.containsKey(newPointHC)) {
                    visited.put(newPointHC, makeEdgeList(pointHC));

                    if (!visited.containsKey(pointHC)) {
                        visited.put(pointHC, makeEdgeList(newPointHC));
                    } else {
                        visited.get(pointHC).add(newPointHC);
                    }
                } else if (visited.containsKey(newPointHC) && !(visited.get(newPointHC).contains(pointHC))) {
                    visited.get(newPointHC).add(pointHC);
                    visited.get(pointHC).add(newPointHC);
                    cnt++;
                }

                pointHC = newPointHC;
            }
        }

        return cnt;
    }

    public List<Pair> makeEdgeList(Pair pointHC) {
        List<Pair> edge = new ArrayList<>();
        edge.add(pointHC);
        return edge;
    }

    static class Pair {

        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public boolean equals(Object o) {
            return this.x == ((Pair) o).x && this.y == ((Pair) o).y;
        }
    }
}