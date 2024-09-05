class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int[] pos = {0, 0};        
        Set<List<Integer>> set = new HashSet<>();
        for(int[] obstacle : obstacles) set.add(Arrays.asList(obstacle[0], obstacle[1]));
        int curDir = 0;
        int max = 0;
        
        for (int cmd : commands) {
            if(cmd == -1)  curDir = (curDir + 1) % 4;
            else if(cmd == -2) curDir = (curDir + 3) % 4;
            else{
                for (int i = 0; i < cmd; i++) {
                    if (!set.contains(Arrays.asList(pos[0] + dir[curDir][0], pos[1] + dir[curDir][1]))) {
                        pos[0] += dir[curDir][0];
                        pos[1] += dir[curDir][1];
                        max = Math.max(max, pos[0] * pos[0] + pos[1] * pos[1]);
                    } else {
                        break;
                    }
                }
            }
        }
        
        return max;
    }
}