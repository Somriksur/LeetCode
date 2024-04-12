class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;

        int water = 0;
        int maxLeft = 0;
        int maxRight = height.length - 1;
        int max = 0;

        for (int j = 0; j < height.length; j++) {
            if (height[max] < height[j]) max = j;
        }
        
        for (int i = 1; i <= max; i++) {
            if (height[i] < height[maxLeft]) {
                water += (height[maxLeft] - height[i]);
            } else {
                maxLeft = i;
            }
        }

        for (int i = height.length - 2; i > max; i--) {
            if (height[i] < height[maxRight]) {
                water += (height[maxRight] - height[i]);
            } else {
                maxRight = i;
            }
        }

        return water;
    }
}