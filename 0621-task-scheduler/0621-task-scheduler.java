class Solution {
    public int leastInterval(char[] tasks, int n) {
        int fr[][]=new int[26][2],i,j,no=tasks.length,res=0,cnt=0;
        for(i=0;i<no;i++){
            fr[tasks[i]-'A'][0]++;
        }
        for(i=0;i<26;i++)fr[i][1]=-101;
        Arrays.sort(fr,(a,b)->b[0]-a[0]);
        while(cnt<no){
            for(i=0;i<26 && fr[i][0]>0 && i<=n;i++){
                if(res-fr[i][1]<=n){
                    res+=n-(res-fr[i][1])+1;
                }
                fr[i][1]=res;
                res++;
                fr[i][0]--;
                cnt++;
            }
            Arrays.sort(fr,(a,b)->b[0]-a[0]);
        }
        return res;
    }
}