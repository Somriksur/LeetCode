class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int indxMask = 0; indxMask < (1 << size); indxMask++) {
            List<Integer> currSubSet = new ArrayList<>();
            for (int indx = 0; indx < size; indx++) {
                if ((indxMask & (1 << indx)) != 0) {
                    currSubSet.add(nums[indx]);
                }
            }
            res.add(currSubSet);
        }
        return res;
    }
}