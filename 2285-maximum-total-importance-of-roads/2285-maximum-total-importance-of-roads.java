class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int degs[] = new int[n];
        for(var road : roads){
            degs[road[0]]--;
            degs[road[1]]--;
        }
        Arrays.sort(degs);
        long totalImp = 0;
        int assignNum = n;
        for(var deg : degs){
            totalImp += ((1l * -1 * deg) * assignNum--);
        }
        return totalImp;
    }
}