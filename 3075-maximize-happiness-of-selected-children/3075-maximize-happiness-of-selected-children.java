class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        Arrays.sort(happiness);
        long max = 0;
        int n = happiness.length;
        int i = n-1;

        while(k>0 && i>=0)
        {
            if(i>=0)
            {
                
                max += Math.max(0, happiness[i] - (n - i-1 ));
            i--;
            k--;

            }
        }
        return max;
    }
}