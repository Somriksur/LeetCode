class Solution {
    public int heightChecker(int[] heights) {
        int result = 0;
        int length = heights.length;
        int[] cloneHeights = heights.clone();
        Arrays.sort(cloneHeights);
        for(int i=0;i<length;++i) {
            if(cloneHeights[i]!=heights[i]) {
                ++result;
            }
        }
        return result;
    }
}