
// O(N*M*M)

class Solution {
    public long maxPoints(int[][] points) {
        
        int n = points.length;
        int m = points[0].length;
        long[][] dp = new long[n][m];
        for(int i=0;i<n;i++){
             Arrays.fill(dp[i],Long.MIN_VALUE);
        }
        for(int i=0;i<m;i++) dp[0][i]=points[0][i];

        for(int i=1;i<n;i++){

            for(int j=0;j<m;j++){
                long maxi = Long.MIN_VALUE;
                for(int k=0;k<m;k++){

                    maxi = Math.max(maxi,dp[i-1][k]-Math.abs(k-j));
                }

                dp[i][j] = (long)points[i][j]+maxi;
            }
        }

        long answer = Long.MIN_VALUE;

        for(int i=0;i<m;i++) answer = Math.max(answer,dp[n-1][i]);

        return answer;
        
    }
}

// O(N*M)
class Solution {
    public long maxPoints(int[][] points) {
        
        int n = points.length;
        int m = points[0].length;
        long[][] dp = new long[n][m];
        for(int i=0;i<n;i++){
             Arrays.fill(dp[i],Long.MIN_VALUE);
        }
        for(int i=0;i<m;i++) dp[0][i]=points[0][i];

        for(int i=1;i<n;i++){

            long[] left = new long[m];
            long[] right = new long[m];

            left[0] = dp[i-1][0];
            for(int j=1;j<m;j++) left[j] = Math.max(dp[i-1][j],left[j-1]-1);

            right[m-1] = dp[i-1][m-1];
            for(int j=m-2;j>=0;j--) right[j] = Math.max(dp[i-1][j],right[j+1]-1);

            for(int j=0;j<m;j++){
                dp[i][j] = points[i][j]+Math.max(left[j],right[j]);
            }
            // System.out.println(Arrays.toString(dp[i]));
        }

        long answer = Long.MIN_VALUE;

        for(int i=0;i<m;i++) answer = Math.max(answer,dp[n-1][i]);

        return answer;
        
    }
}