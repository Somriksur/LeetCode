class Solution {
    private static final int RESULT_SIZE = 1;
    private static final int RESULT_MARKER = -1;
    private static final int MARKER_IDX = 0;
    private static final int BLOCKED = 10001;
    private static final int[] DIVISORS = new int[] {1000, 100, 10, 1};
    
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        int[] map = new int[10000];
        Set<Integer> deadendsSet = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            map[convertLockToInt(deadends[i])] = BLOCKED;
        }
        if (map[0] == BLOCKED) {
            return -1;
        }
        int targetInt = convertLockToInt(target);
        map[0] = 1;
        map[targetInt] = -1;
        
        List<Integer> fromStart = new ArrayList<>();
        fromStart.add(0);
        
        List<Integer> fromTarget = new ArrayList<>();
        fromTarget.add(targetInt);
        
        int distance = 1;
        while (!fromStart.isEmpty() && !fromTarget.isEmpty()) {
            fromStart = getNextLayer(map, fromStart, 1);
            if (fromStart.size() == RESULT_SIZE && fromStart.get(MARKER_IDX) == RESULT_MARKER) {
                return distance;
            } 
            distance += 1;
            fromTarget = getNextLayer(map, fromTarget, -1);
            if (fromTarget.size() == RESULT_SIZE && fromTarget.get(MARKER_IDX) == RESULT_MARKER) {
                return distance;
            } 
            distance += 1;
        }
        return -1;
    }
    private List<Integer> getNextLayer(int[] map, List<Integer> layer, int direction) {
        List<Integer> nextLayer = new ArrayList();
            for (int lock : layer) {
                for (int place = 0; place < 4; place++) {
                    for (int rotations = -1; rotations <= 1; rotations += 2) {
                        int rotatedLock = rotateLock(lock, place, rotations);
                        int rotatedLockMarker = map[rotatedLock];
                        if (rotatedLockMarker == BLOCKED ||
                            (direction > 0 && rotatedLockMarker > 0) || 
                            (direction < 0 && rotatedLockMarker < 0)) {
                            continue;
                        }
                        if ((direction > 0 && rotatedLockMarker < 0) ||
                           (direction < 0 && rotatedLockMarker > 0)) {
                            nextLayer.clear();
                            nextLayer.add(-1);
                            return nextLayer;
                        }
                        map[rotatedLock] = direction;
                        nextLayer.add(rotatedLock);
                    }
                }
            }
        return nextLayer;
    }
    private int rotateLock(int lock, int place, int rotations) {
        int curr = (lock / DIVISORS[place]) % 10;
        int next = (curr + rotations + 10) % 10;
        return lock + (DIVISORS[place] * (next - curr));
    }
    private int convertLockToInt(String lock) {
        int num = 0;
        for (int i = 0; i < lock.length(); i++) {
            num *= 10;
            num += lock.charAt(i) - '0';
        }
        return num;
    }
}