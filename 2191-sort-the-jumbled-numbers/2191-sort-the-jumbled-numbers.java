class Info {
    int num;
    int val;

    public Info(int num, int val) {
        this.num = num;
        this.val = val;
    }
}

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mapping.length; i++) {
            int ind = mapping[i];
            map.put(ind, mapping[ind]);
        }
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            StringBuilder sb = new StringBuilder();
            if(n==0){
                int x = n % 10;
                sb.append(String.valueOf(map.get(x)));
                n = n / 10;
            }
            while (n > 0) {
                int x = n % 10;
                sb.append(String.valueOf(map.get(x)));
                n = n / 10;
            }
            sb.reverse();
            list.add(new Info(nums[i], Integer.valueOf(sb.toString())));
        }
        Collections.sort(list, (info1, info2) -> Integer.compare(info1.val, info2.val));
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i).num;
            // System.out.println(list.get(i).num + " -> " + list.get(i).val);
        }
        return nums;
    }
}