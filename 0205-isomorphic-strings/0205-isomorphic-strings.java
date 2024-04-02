class Solution {
    public boolean isIsomorphic(String s, String t) {
           Map<Character,Character> mp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char  original = s.charAt(i);
            char  mapped = t.charAt(i);
            if(!mp.containsKey(original)){
                if(!mp.containsValue(mapped)){
                    mp.put(original,mapped);
                }
                else{
                    return false;

                }
            }
            else{
                char ch = mp.get(original);
                if( ch != mapped){
                    return false;
                }
            }
        }
         return true;
    }
}