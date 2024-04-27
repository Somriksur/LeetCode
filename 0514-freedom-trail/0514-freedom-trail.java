class Solution {
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length() + 1][ring.length()];

        for (int i = key.length() - 1; i >= 0; i--) {
            for (int j = 0; j < ring.length(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < ring.length(); k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(k - j);
                        int steps = Math.min(diff, ring.length() - diff);
                        dp[i][j] = Math.min(dp[i][j], steps + dp[i + 1][k]);
                    }
                }
            }
        }
        return key.length() + dp[0][0];
    }
}