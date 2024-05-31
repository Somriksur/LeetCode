class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int val = 0;
        for (int num : nums){
            val ^= num;
        }
        val = val & -val;
        for (int num : nums) {
            if ((num & val) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}