class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remaining, int start) {
        if (remaining < 0) {
            return;
        } 
        else if (remaining == 0) {
            
            result.add(new ArrayList<>(current));
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                // Skip duplicates to avoid duplicate combinations
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                current.add(candidates[i]);
                backtrack(result, current, candidates, remaining - candidates[i], i+1);
                current.remove(current.size() - 1);
            }
        }
    }
}