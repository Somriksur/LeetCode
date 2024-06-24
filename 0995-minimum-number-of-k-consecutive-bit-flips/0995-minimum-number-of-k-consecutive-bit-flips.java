class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flipped = new int[n];
        int current_flips = 0;
        int flip_count = 0;     
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                current_flips ^= flipped[i - k];
            }
            if ((nums[i] == 0 && current_flips % 2 == 0) || (nums[i] == 1 && current_flips % 2 != 0)) {
                if (i + k > n) {
                    return -1; 
                }
                flipped[i] = 1;
                current_flips++; 
                flip_count++; 
        }
            }
        
        return flip_count;
    }
    }