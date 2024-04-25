class Solution {
    int differ = Integer.MAX_VALUE;
    int  closest_3sum = 0;
    int Tar  = 0;
    boolean flag = false;
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        Tar = target;
        for(int i =0;i<nums.length && !flag ;i++){
             int temp = nums[i];
            if(!set.contains(temp)){
                set.add(temp);
                threeSumClosest_DFS(0,nums,i+1,temp);
            }
        }
        return closest_3sum;

    }

    private void threeSumClosest_DFS(int deep, int[] nums, int cur,int sum ) {
        if (deep == 2 ) {
            int dif_sum = Math.abs(Tar - sum);
            if (differ >= dif_sum) {
                differ = dif_sum;
                closest_3sum = sum;
                if(differ == 0 ){
                    // System.out.println(flag);  
                    flag = true;
                } 
                return;
            }
            return;
        }
        if (cur >= nums.length) return;
        for (int i = cur; i < nums.length && !flag; i++) {
            threeSumClosest_DFS(deep + 1, nums, i + 1, sum + nums[i]);
        }
        
    }
}