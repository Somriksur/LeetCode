class Solution {
    public int matrixScore(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][0] == 0) {
                flipRow(i, grid);
            }
        }

        for(int i = 1; i < grid[0].length; i++) {
            int count = count(i, grid);
            if(count <= grid.length / 2) {
                flipCol(i, grid);
            }
        }
        int rs = 0;
        for(int i = 0; i < grid.length; i++) {
            int temp = 0;
            for(int j = 0; j < grid[i].length; j++) {
                temp = temp * 2 + grid[i][j];
            }
            rs += temp;
        }
        return rs;
    }

    int count(int i, int[][] grid) {
        int rs = 0;
        for(int j = 0; j < grid.length; j++) {
            rs += grid[j][i];
        }
        return rs;
    }

    void flipCol(int i, int[][] grid) {
        for(int j = 0; j < grid.length; j++) {
            grid[j][i] = grid[j][i] == 0 ? 1 : 0;
        }
    }

    void flipRow(int i, int[][] grid) {
        for(int j = 0; j < grid[i].length; j++) {
            grid[i][j] = grid[i][j] == 0 ? 1 : 0;
        }
    }
}