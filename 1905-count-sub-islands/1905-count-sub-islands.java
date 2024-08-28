class Solution {
    private int[][] grid1;
    private int[][] grid2;
    private int n;
    private int m;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        this.n = grid1.length;
        this.m = grid1[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    if (bfs(i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean bfs(int currentN, int currentM) {
        boolean top = (currentN > 0);
        boolean right = (currentM < m - 1);
        boolean bottom = (currentN < n - 1);
        boolean left = (currentM > 0);

        boolean topRes = true, rightRes = true, bottomRes = true, leftRes = true;

        grid2[currentN][currentM] = 0;

        if (top && grid2[currentN - 1][currentM] == 1) {
            topRes = bfs(currentN - 1, currentM);
        }

        if (right && grid2[currentN][currentM + 1] == 1) {
            rightRes = bfs(currentN, currentM + 1);
        }

        if (bottom && grid2[currentN + 1][currentM] == 1) {
            bottomRes = bfs(currentN + 1, currentM);
        }

        if (left && grid2[currentN][currentM - 1] == 1) {
            leftRes = bfs(currentN, currentM - 1);
        }

        if (grid1[currentN][currentM] == 0) {
            return false;
        }

        return topRes && rightRes && bottomRes && leftRes;
    }
}