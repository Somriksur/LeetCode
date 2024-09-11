class Solution {
    public int minBitFlips(int start, int goal) {
        int num = start ^ goal, cnt = 0;
        while (num != 0) {
            cnt++;
            num = num & (num - 1);
        }
        return cnt;
    }
}