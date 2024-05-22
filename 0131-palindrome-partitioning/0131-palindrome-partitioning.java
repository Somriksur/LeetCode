class Solution {
   private void helper(int index, String s, List<String>curr, List<List<String>>res, int len)
    {
        if(index>=len)
        {
            res.add(new ArrayList<>(curr));
            return ;
        }
        for( int i=index; i<len; i++)
        {
            String substr=s.substring(index, i+1);
            if(isPalindrome(substr))
            {
                curr.add(substr);
                helper(i+1, s, curr, res, len);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s)
    {
        int left=0, right=s.length()-1;
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        List<String>curr=new ArrayList<>();
        helper(0, s, curr, res,s.length() );
        return res;
    }
}