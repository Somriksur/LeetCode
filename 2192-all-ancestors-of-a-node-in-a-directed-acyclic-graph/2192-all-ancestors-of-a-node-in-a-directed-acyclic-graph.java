import java.util.*;

class Solution {
    private void dfs(List<List<Integer>> graph, int src, List<Integer> temp, boolean[] vis) {
        vis[src] = true;
        for (int parent : graph.get(src)) {
            if (!vis[parent]) {
                temp.add(parent);
                dfs(graph, parent, temp, vis);
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
       
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(to).add(from); 
        }

      
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            boolean[] vis = new boolean[n];
            dfs(graph, i, temp, vis);
            Collections.sort(temp);
            output.add(temp);
        }

        return output;
    }
}