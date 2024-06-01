import java.util.*;

class Solution {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    char[][] map = new char[101][101];

    public int solution(int[][] rectangle, int X, int Y, int itemX, int itemY) {
        for (int[] coords : rectangle) {
            int y1 = coords[1];
            int x1 = coords[0];
            int y2 = coords[3];
            int x2 = coords[2];

            draw(y1 * 2, x1 * 2, y2 * 2, x2 * 2);
        }

        return bfs(Y * 2, X * 2, itemY * 2, itemX * 2);
    }

    public int bfs(int Y, int X, int findY, int findX) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{Y, X, 0});
        boolean[][] visited = new boolean[101][101];

        while (!queue.isEmpty()) {
            Integer[] temp = queue.poll();
            int prevY = temp[0];
            int prevX = temp[1];
            int count = temp[2];

            if (prevY == findY && prevX == findX) {
                return count / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = prevY + dy[i];
                int nextX = prevX + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length) {
                    continue;
                }
                if (visited[nextY][nextX] || map[nextY][nextX] != '2') {
                    continue;
                }

                visited[nextY][nextX] = true;
                queue.add(new Integer[]{nextY, nextX, count + 1});
            }
        }

        return 0;
    }

    public void draw(int y1, int x1, int y2, int x2) {

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (map[i][j] == '1') {
                    continue;
                }

                map[i][j] = '1';

                if (i == y1 || i == y2 || j == x1 || j == x2) {
                    map[i][j] = '2';
                }
            }
        }
    }
}
