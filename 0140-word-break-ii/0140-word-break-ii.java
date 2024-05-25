class Solution {
    private List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList();
        Set<String> set = new HashSet(wordDict);
        solve(s, 0, set, new StringBuilder());

        return ans;
    }

    private void solve(String s, int index, Set<String> wordDict, StringBuilder sb){

        if(index >= s.length()){
            ans.add(sb.toString().trim());
            return;
        }

        for(int i=index; i<s.length(); i++){
            String sub = s.substring(index, i+1);
            if(wordDict.contains(sub)){
                int prevLen = sb.length();
                sb.append(sub).append(" ");
                solve(s, i+1, wordDict, sb);
                sb.setLength(prevLen);   
            }
        }
    }
}