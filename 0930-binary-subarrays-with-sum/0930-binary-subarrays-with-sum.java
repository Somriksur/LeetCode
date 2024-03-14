class Solution {

public int numSubarraysWithSum(int[] nums, int goal) {
    if (nums == null || nums.length == 0) return 0;
    final int N = nums.length;
    int[] count = new int[N + 1];
    count[0] = 1;
    int res = 0;
    int sum = 0;
    for (int i = 0; i < N; i++) {
        sum += nums[i];
        if (sum >= goal) {
            res += count[sum - goal];
        }
        count[sum]++;
    }
    return res;
}
}