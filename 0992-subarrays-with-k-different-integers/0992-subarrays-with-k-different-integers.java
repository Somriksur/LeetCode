class Solution {
    
    int help(int[] nums, int k){
        int l = 0;
        int n = nums.length;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int r = 0;r < n;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size() > k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l]) < 1){
                    map.remove(nums[l]);
                }
                l++;
            }
            count += r-l+1;
        }
        return count;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        return help(nums,k) - help(nums,k-1);
    }
}