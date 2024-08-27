class Solution {
    public class Edge {
        int v;
        double success;

        Edge(int v, double success){
            this.v = v;
            this.success = success;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < succProb.length; i++) {
            graph.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));
        }
        double dist[] = new double[n];
        dist[start_node] = 1.0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(b.success, a.success));
        pq.add(new Edge(start_node, 1.0));

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            
            for (Edge neigh : graph.get(e.v)) {
                if (dist[neigh.v] < dist[e.v]*neigh.success) {
                    dist[neigh.v] = dist[e.v]*neigh.success;
                    pq.add(new Edge(neigh.v, dist[e.v]));
                }
            }
        }
        return dist[end_node];
    }
}