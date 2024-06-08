class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0)
                return true;
        }

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            if (prefix[i] % k == 0) {
                return true;
            }

            int s = i - 2;
            while (s >= 0 && (prefix[i] - prefix[s]) >= k) {
                if ((prefix[i] - prefix[s]) % k == 0) {
                    return true;
                }
                s--;
            }
        }
        return false;
    }
}