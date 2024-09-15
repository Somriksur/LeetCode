class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int res = 0;
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            curr = curr ^ (1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1);
            map.putIfAbsent(curr, i);
            res = Math.max(res, i - map.get(curr));
        }
        return res;
    }
}