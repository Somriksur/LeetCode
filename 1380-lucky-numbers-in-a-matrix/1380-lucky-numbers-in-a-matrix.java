class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] minRow = new int[m];
        int[] maxCol = new int[n];

        for (int i = 0; i < m; i++) {
            minRow[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    answer.add(matrix[i][j]);
                }
            }
        }

        return answer;
    }
}