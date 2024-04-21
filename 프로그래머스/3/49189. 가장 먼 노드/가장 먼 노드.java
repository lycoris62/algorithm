import java.util.*;

class Solution {
    
    int[] distances;
    boolean[] visited;
    List<Edge>[] adjList;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // Edge의 Cost가 1인 경우로 다익스트라 풀기
        // distances 중, 가장 큰 값을 구하고 그 개수가 정답. 
        
        // 1번 노드를 시작점으로 하고, 각 노드까지의 거리를 distances에 저장, 초깃값 정수 최댓값으로. 
        // 방문한 노드를 체크하는 visited도 필요. 
        // 다익스트라는 내부적으로 우선순위큐를 씀.
        // 엣지의 비용이 1이므로, 노드 클래스는 목적지만을 저장 -> 노드 클래스 굳이 필요 없음
        // ㄴ 가 아니라, 딱 그 시점의 그 노드까지의 비용을 포함해야 해서 필요할듯 
        // ㄴ 그리고 노드가 아니라 엣지 
        
        distances = new int[n + 1];
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] aEdge : edge) {
            int a = aEdge[0];
            int b = aEdge[1];
            
            adjList[a].add(new Edge(b, 1));
            adjList[b].add(new Edge(a, 1));
        }
        
        Arrays.fill(distances, Integer.MAX_VALUE);
        
        dijkstra();
        
        distances[0] = 0;
        int maxLen = Arrays.stream(distances).max().getAsInt();
        
        for (int distance : distances) {
            if (distance == maxLen) answer++;
        }
        
        return answer;
    }
    
    void dijkstra() {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        distances[1] = 0;
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if (visited[now.dest]) {
                continue;
            }
            
            visited[now.dest] = true;
            
            for (Edge next : adjList[now.dest]) {
                if (distances[next.dest] > now.cost + next.cost) {
                    distances[next.dest] = now.cost + next.cost;
                    pq.add(new Edge(next.dest, now.cost + next.cost));
                }
            }
        }
    }
    
    class Edge implements Comparable<Edge> {
        int dest, cost;
        
        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}