class Solution {
    private static final int mod = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subArrSum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subArrSum.add(sum);
            }
        }
        Collections.sort(subArrSum);
        int sum = 0;
        for (int i = left - 1; i < right; i++) {
            sum = (sum + subArrSum.get(i)) % mod;
        }
        return sum;
    }
}