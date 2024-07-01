class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        boolean flag = false;
        for(int i=0; i<n-2; i++){
            if(arr[i]%2 != 0 && arr[i+1]%2 != 0 && arr[i+2]%2 != 0){
                flag = true;
            }
        }
        return flag;
    }
}