class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer>m=new HashMap<>();
        String sa1[]=s1.split(" "),sa2[]=s2.split(" ");
        for(String c:sa1)
         m.put(c, m.getOrDefault(c, 0) + 1);
        for(String c:sa2)
         m.put(c, m.getOrDefault(c, 0) + 1);
       ArrayList<String> a = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                a.add(entry.getKey());
            }
        }
        String ans[]=new String[a.size()];
        int l=0;
        for(String c:a)
        ans[l++]=c;
        return ans;
    }
}