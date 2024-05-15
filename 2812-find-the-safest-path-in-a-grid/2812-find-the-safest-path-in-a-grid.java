class Solution {
    public class pair{
        int row;
        int col;
        public pair(int row, int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        int[][]matrix=new int[n][n];
        for(int[]m: matrix) Arrays.fill(m,Integer.MAX_VALUE);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
              if(grid.get(i).get(j)==1) bfs(grid,i,j,matrix);
            }
        }

        int ans=0, low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0;  i < n; i++) {
            for (int j = 0; j < n; j++) {
                low = Math.min(low, matrix[i][j]);
                high = Math.max(high, matrix[i][j]);
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid,matrix)) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return ans;

    }

    public boolean isPossible(int mid, int[][]matrix)
    {
        int n=matrix.length;
        if(matrix[0][0]<mid || matrix[n-1][n-1]<mid) return false;

        int[]dx={1,0,-1,0};
        int[]dy={0,1,0,-1};
        Queue<pair> q = new LinkedList<>();
        boolean[][]vis=new boolean[n][n];
        q.add(new pair(0,0));

        while(!q.isEmpty())
        {
            pair pp=q.poll();
            int x=pp.row;
            int y=pp.col;
            if(vis[x][y]) continue;
            vis[x][y]=true;

            for(int k=0;k<4;k++)
            {
                int new_x=x+dx[k];
                int new_y=y+dy[k];

                if(new_x>=0 && new_x<n && new_y>=0 && new_y<n && vis[new_x][new_y]==false && matrix[new_x][new_y]>=mid)
                {
                    q.add(new pair(new_x,new_y));
                }
            }
        }
        return vis[n-1][n-1];

    }

    public void bfs(List<List<Integer>>grid, int x, int y, int[][]matrix)
    {
        matrix[x][y]=0;
        Queue<pair>q = new LinkedList<>();
        q.offer(new pair(x,y));
        int[]dx={1,0,-1,0};
        int[]dy={0,1,0,-1};
        int i=0;
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int r=p.row;
            int c=p.col;

            for(int k=0;k<4;k++)
            {
                int new_r=r+dx[k];
                int new_c=c+dy[k];
                if(new_c>=0 && new_c<matrix.length && new_r>=0 && new_r< matrix.length&& matrix[new_r][new_c] > 1 + matrix[r][c])
                {
                    q.add(new pair(new_r,new_c));
                    matrix[new_r][new_c]=1+matrix[r][c];
                }

            }

        }
    }
}