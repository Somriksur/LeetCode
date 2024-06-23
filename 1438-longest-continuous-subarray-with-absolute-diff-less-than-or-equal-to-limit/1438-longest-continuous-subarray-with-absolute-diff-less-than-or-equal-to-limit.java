class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> maxD = new ArrayDeque<>();
        ArrayDeque<Integer> minD = new ArrayDeque<>();
        int i = 0, res = 0;
        
        for (int j = 0; j < nums.length; j++) {
            while (!maxD.isEmpty() && nums[j] > maxD.peekLast()) {
                maxD.pollLast();
            }
            while (!minD.isEmpty() && nums[j] < minD.peekLast()) {
                minD.pollLast();
            }
            maxD.offerLast(nums[j]);
            minD.offerLast(nums[j]);
            
            while (maxD.peekFirst() - minD.peekFirst() > limit) {
                if (maxD.peekFirst() == nums[i]) {
                    maxD.pollFirst();
                }
                if (minD.peekFirst() == nums[i]) {
                    minD.pollFirst();
                }
                i++;
            }
            
            res = Math.max(res, j - i + 1);
        }
        
        return res;
    }
}