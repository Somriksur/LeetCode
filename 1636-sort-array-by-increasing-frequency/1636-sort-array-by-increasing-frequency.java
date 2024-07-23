class Solution {
    public int[] frequencySort(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) 
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a,b) -> (map.get(a) == map.get(b))? b - a : map.get(a) - map.get(b));
        
        int p = 0;
        while(keys.size() > 0) {
            int ele = keys.get(0);
            int freq = map.get(ele);
            
            for(int i=0; i<freq; i++)
                nums[p++] = ele;
            keys.remove(0);
        }
        
        return nums;
    }
}