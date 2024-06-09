class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        hp.put(0,1);

        int sum = 0;
        int ans = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            sum = (sum+arr[i])%k;
            if(sum<0) sum+=k;
            ans += hp.getOrDefault(sum, 0);
            hp.put(sum, hp.getOrDefault(sum, 0) + 1);
        }
        
        return ans;
    }
}