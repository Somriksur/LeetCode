class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        for (int j = 0; j < n2; j++) {
            for (int i = 0; i < n1; i++) {
                if (arr1[i] == arr2[j]) {
                    ans.add(arr1[i]);
                    arr1[i] = -1;
                }
            }
        }
        
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            if (arr1[i] > -1) {
                remaining.add(arr1[i]);
            }
        }
        
        // Sort remaining elements
        remaining.sort(null);
        ans.addAll(remaining);
        
        // Convert List<Integer> to int[]
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}