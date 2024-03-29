class Solution {
    public long countSubarrays(int[] nums, int k) {
        int left = 0;
        int maxValue = Integer.MIN_VALUE;
        int count = 0;
        long result = 0;

        for(int i : nums){
            if(i > maxValue) maxValue = i;
        }

        for(int i : nums){
            if( i == maxValue) count++;

            while(count >= k){
                if(nums[left++] == maxValue) --count;
            }
            result += left;
        }
        return result;
    }
}