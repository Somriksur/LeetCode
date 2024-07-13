class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
          int n = positions.length;
        List<Integer> rindex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rindex.add(i);
        }
        Collections.sort(rindex ,(a, b) -> (positions[a]- positions[b]));

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : rindex) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && healths[i] > 0) {
                if (healths[stack.peek()] < healths[i]) {
                    healths[stack.pop()] = 0;
                    healths[i] -= 1;
                } else if (healths[stack.peek()] > healths[i]) {
                    healths[stack.peek()] -= 1;
                    healths[i] = 0;
                } else {
                    healths[stack.pop()] = 0;
                    healths[i] = 0;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int h: healths) {
            if (h> 0) {
                ans.add(h);
            }
        }
        return ans;
    }
}