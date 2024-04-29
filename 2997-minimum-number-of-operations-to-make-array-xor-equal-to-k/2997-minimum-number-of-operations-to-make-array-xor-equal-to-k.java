class Solution {
    public int minOperations(int[] nums, int k) {
        int count = k, ans = 0;
        for (int num : nums) {
            count ^= num;
        }
        while (count != 0) {
            ans += count & 1;
            count >>= 1;
        }
        return ans;
    }
}