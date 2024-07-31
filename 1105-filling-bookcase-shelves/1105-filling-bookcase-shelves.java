class Solution {
    Integer[] memo;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        memo = new Integer[n];
        return solve(books, shelfWidth, 0);
    }

    public int solve(int[][] books, int shelfWidth, int ind) {
        if(ind == books.length) return 0;
        if(memo[ind] != null) return memo[ind];
        int ans = Integer.MAX_VALUE, maxH = 0, width = 0;
        for(int i=ind;i<books.length;i++) {
            width += books[i][0];
            if(width > shelfWidth) break;
            maxH = Math.max(maxH, books[i][1]);
            ans = Math.min(ans, maxH + solve(books, shelfWidth, i+1));
        }
        return memo[ind] = ans;
    }
}