class Solution {
    public int specialArray(int[] nums) {
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }

            if (count == i) {
                return count;
            }
            count = 0;
        }
        return -1;
    }
}