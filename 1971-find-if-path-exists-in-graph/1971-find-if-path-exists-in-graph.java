class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> vis;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        map = new HashMap<>();
        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            map.putIfAbsent(u, new ArrayList<Integer>());
            map.putIfAbsent(v, new ArrayList<Integer>());
            map.get(v).add(u);
            map.get(u).add(v);
        }
        vis = new HashSet<Integer>();
        return dfs(source, destination);
    }
    public boolean dfs(int u, int target){
        if(u == target)
            return true;
        vis.add(u);
        for(int v : map.get(u)){
            if(!vis.contains(v) && dfs(v, target))
                return true;
        }
        return false;
    }
}