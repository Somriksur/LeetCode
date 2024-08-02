public class MinSwaps {
    public static int minSwaps(int[] nums) {
        int count = 0;
        for (int x : nums) {
            if (x == 1) count++;
        }
        
        int max1 = 0;
        int si = 0;
        int ei = si + count;
        int ic = 0;
        
        // Initialize the count of 1s in the first window
        for (int i = si; i < ei; i++) {
            if (nums[i % nums.length] == 1) ic++;
        }
        ei--;
        
        while (si < nums.length) {
            if (nums[si % nums.length] == 0 && nums[(ei + 1) % nums.length] == 1) {
                ic++;
            } else if (nums[si % nums.length] == 1 && nums[(ei + 1) % nums.length] == 0) {
                ic--;
            }
            
            if (ic > max1) max1 = ic;
            si++;
            ei++;
        }
        
        return count - max1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1};
        System.out.println(minSwaps(nums));  // Example usage
    }
}