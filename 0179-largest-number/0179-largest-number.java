class Solution {
    public String largestNumber(int[] nums) {
        String s[] = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s,(a,b) -> (b+a).compareTo(a+b));
        StringBuilder result = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            result.append(s[i]);
        }
        return result.charAt(0)=='0'?"0" : result.toString();
    }
}