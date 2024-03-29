class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == target)
                return i; 
            if (i == 0 && target < nums[i]) 
                return i; 
            if (i > 0 && target > nums[i-1] && target < nums[i])
                return i; 
            i++;
        }
        return i;
    }
}