class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if(nums[n-1] > 0) {
                nums[n-1] = -nums[n-1];
            } else {
                list.add(Math.abs(nums[i]));
            }
        }
        return list;
    }
}