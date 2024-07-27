class Solution {
    private static final int NUM_VERTICES = 26;
    
    public long[][] floydWarshall(List<List<Pair>> adjList) {
        long[][] dist = new long[NUM_VERTICES][NUM_VERTICES];
        for (int i = 0; i < NUM_VERTICES; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        for (int i = 0; i < NUM_VERTICES; i++) {
            for (Pair neighbor : adjList.get(i)) {
                dist[i][neighbor.first] = Math.min(dist[i][neighbor.first], neighbor.second);
            }
        }

        for (int k = 0; k < NUM_VERTICES; k++) {
            for (int i = 0; i < NUM_VERTICES; i++) {
                for (int j = 0; j < NUM_VERTICES; j++) {
                    if (dist[i][k] != Long.MAX_VALUE && dist[k][j] != Long.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        return dist;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < NUM_VERTICES; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            long transformationCost = cost[i];
            adjList.get(from).add(new Pair(to, transformationCost));
        }

        long[][] dist = floydWarshall(adjList);
        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';
            if (source.charAt(i) != target.charAt(i)) {
                if (dist[sourceChar][targetChar] == Long.MAX_VALUE) return -1;
                totalCost += dist[sourceChar][targetChar];
            }
        }

        return totalCost;
    }

    static class Pair {
        int first;
        long second;

        Pair(int first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}