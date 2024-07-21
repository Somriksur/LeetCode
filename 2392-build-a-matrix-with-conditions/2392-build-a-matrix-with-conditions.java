class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    List<Integer> row = topologicalSort(k, rowConditions);
    List<Integer> col = topologicalSort(k, colConditions);
    int[][] arr = new int[k][k];

    // Debug prints for row and col
    System.out.println("Topological sort (rows): " + row);
    System.out.println("Topological sort (columns): " + col);
    
    if (row.size() == 0 || col.size() == 0) {
        return new int[][]{};
    }

    Map<Integer, Integer> rowPosition = new HashMap<>();
    Map<Integer, Integer> colPosition = new HashMap<>();

    for (int i = 0; i < row.size(); i++) {
        rowPosition.put(row.get(i), i);
        System.out.println("rowPosition: " + row.get(i) + " -> " + i);
    }

    for (int i = 0; i < col.size(); i++) {
        colPosition.put(col.get(i), i);
        System.out.println("colPosition: " + col.get(i) + " -> " + i);
    }

    for (int i = 1; i <= k; i++) {
        if (rowPosition.containsKey(i) && colPosition.containsKey(i)) {
            int rowIndex = rowPosition.get(i);
            int colIndex = colPosition.get(i);
            System.out.println("Placing " + i + " at arr[" + rowIndex + "][" + colIndex + "]");
            arr[rowIndex][colIndex] = i;
        }
    }

    return arr;
}

    public List<Integer> topologicalSort(int k, int[][] conditions) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();
    Set<Integer> nodes = new HashSet<>();

    // Ensure all nodes from 1 to k are in the graph
    for (int i = 1; i <= k; i++) {
        graph.putIfAbsent(i, new ArrayList<>());
        inDegree.putIfAbsent(i, 0);
        nodes.add(i);
    }

    // Step 1: Create the adjacency list and in-degree count
    for (int[] condition : conditions) {
        int above = condition[0];
        int below = condition[1];
        graph.get(above).add(below);
        inDegree.put(below, inDegree.get(below) + 1);
    }

    // Step 2: Initialize the queue with nodes having zero in-degree
    Queue<Integer> queue = new LinkedList<>();
    for (int node : nodes) {
        if (inDegree.get(node) == 0) {
            queue.offer(node);
        }
    }

    List<Integer> topologicalOrder = new ArrayList<>();

    // Step 3: Process nodes in the queue
    while (!queue.isEmpty()) {
        int current = queue.poll();
        topologicalOrder.add(current);

        for (int neighbor : graph.get(current)) {
            inDegree.put(neighbor, inDegree.get(neighbor) - 1);
            if (inDegree.get(neighbor) == 0) {
                queue.offer(neighbor);
            }
        }
    }

    // If we have processed all nodes, return the order
    if (topologicalOrder.size() == k) {
        return topologicalOrder;
    } else {
        return Collections.emptyList();  // If there's a cycle or disconnected graph, return an empty list
    }
}

    }