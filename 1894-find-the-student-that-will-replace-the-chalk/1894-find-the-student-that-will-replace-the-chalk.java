class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;
        for (int amount : chalk) {
            totalChalk += amount;
        }
        
        totalChalk = (int) k % totalChalk;
        
        for (int i = 0; i < chalk.length; i++) {
            if (totalChalk < chalk[i]) {
                return i;
            }
            totalChalk -= chalk[i];
        }
        
        return -1; 
    }
}