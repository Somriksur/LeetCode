class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length()-needle.length()+1;i++){   // Iterate over the haystack and go till every possible starting point of the string.
            // check substring of i to size needle.length() is equal to needle or not if it is equal then return i.
            if(haystack.substring(i,needle.length()+i).equals(needle)){
                return i;
            }
        }
        return -1;   // return -1.
    }
}