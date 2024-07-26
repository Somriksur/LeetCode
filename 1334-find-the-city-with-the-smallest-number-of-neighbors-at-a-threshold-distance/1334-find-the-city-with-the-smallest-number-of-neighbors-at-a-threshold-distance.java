class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj = new int[n][n];

        for(int i = 0;i<n;i++){
            Arrays.fill(adj[i],1000000000);
            adj[i][i] = 0;
        }

        for(int[] edge : edges){
            adj[edge[0]][edge[1]] = edge[2];
            adj[edge[1]][edge[0]] = edge[2];
        }

         for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        int res = -1;
        int min_cities = Integer.MAX_VALUE;

        int[] reachable = new int[n];
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if (i != j && adj[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            reachable[i] = cnt;
            if(cnt<=min_cities){
                min_cities = cnt;
                res = i;
            }   
        }
        return res;
    }
}