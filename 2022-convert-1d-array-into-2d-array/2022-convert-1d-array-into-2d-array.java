class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Edge
        if (m * n != original.length) {
            return new int[0][0];
        }

        int x = 0;
        int[][] cA = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cA[i][j] = original[x++];
            }
        }
        return cA;
    }
}