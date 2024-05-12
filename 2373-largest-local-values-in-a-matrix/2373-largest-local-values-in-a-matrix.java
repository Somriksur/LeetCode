class Solution {
    public int[][] largestLocal(int[][] grid) {
        int [][]result=new int [grid.length-2][grid.length-2];
        for(int row=0;row<grid.length-2;row++)
        {
            for(int col=0;col<grid.length-2;col++)
            {
                result[row][col]=maxvalue(grid,row,col);
            }
        }
        return result;
        
    }
    public int maxvalue(int [][]grid,int row,int col)
        {
            int max=Integer.MIN_VALUE;
            for(int i=row;i<=row+2;i++)
            {
                for(int j=col;j<=col+2;j++)
                {
                    max=Math.max(max,grid[i][j]);
                }
            }
            return max;
        }
}