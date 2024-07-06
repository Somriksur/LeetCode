class Solution {
    public int passThePillow(int n, int time) {
        int rem=time%(n-1);
        int ans=0;
        if ((time/(n-1))%2==0)
        {
            ans=rem+1;
        }
        else
        {
            ans=n-rem;
        }
        return ans;
    }
}