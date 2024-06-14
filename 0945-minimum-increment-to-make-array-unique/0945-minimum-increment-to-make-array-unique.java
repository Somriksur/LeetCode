class Solution {
  public int minIncrementForUnique(int[] nums) {
    Arrays.sort(nums);
    var i = 0;
    var cnt = 0;

    for (var n : nums) {
      i = Math.max(i, n);

      cnt += i++ - n;
    }
    return cnt;
  }
}