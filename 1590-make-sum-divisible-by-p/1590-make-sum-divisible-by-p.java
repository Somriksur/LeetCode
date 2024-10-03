class Solution {

    public int minSubarray(int[] nums, int p) {

        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.put(0, nums.length);
        int sum = 0;
        int rightSum = 0;
        int mini = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;
        }
        if (sum % p == 0)
            return 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            sum = (sum - (nums[i]) % p + p) % p;
            rightSum = (rightSum + nums[i]) % p;
            mp.put(rightSum, i);

            if (sum == 0) {
                mini = Math.min(mini, mp.get(0) - i);
            } else if (mp.containsKey(p - sum)) {
                mini = Math.min(mini, mp.get(p - sum) - i);
            }
        }
        if (mini == nums.length)
            return -1;
        return mini;
    }
}