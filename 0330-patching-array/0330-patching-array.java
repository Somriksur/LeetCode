class Solution {
    public int minPatches(int[] nums, int n) {
        int ans = 0, i = 0;
        long s = 1;
        while (s <= n) {
            if (i < nums.length && nums[i] <= s) {
                s += nums[i++];
            } else {
                s *= 2; 
                ans++;
            }
        }
        return ans;
    }
}