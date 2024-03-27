class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if(k<=1) return 0;
        int n = arr.length,ans = 0,i=0,j=0,p=1;
        while(j<n){
            p = p*arr[j];
            while(p>=k){
                ans += (j-i);
                p /= arr[i];
                i++;
            }
            j++;
        }
        while(i<n){
            ans = ans+(j-i);
            p = p/arr[i];
            i++;
        }
        return ans;
    }
}