class Solution {
    public int findMaxK(int[] nums) {
      int max=Integer.MIN_VALUE;
      ArrayList<Integer>list= new ArrayList<>();
      for(int i=0; i<nums.length; i++)
      {
        list.add(nums[i]);
      }
      for( int i=0; i<nums.length; i++)
      {
       
        if(nums[i]<0 && list.contains((Math.abs(nums[i]))) && max<Math.abs(nums[i]))
        {
          
            max=Math.abs(nums[i]);
        }
      }
      if(max<0)
      {
        return -1;
      }
      return max;
    }
}