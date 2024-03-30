class Solution {
    public int lengthOfLastWord(String s) {
          int b = s.length();
        int count1 =0;
        int count = 0;
        if (s.charAt(b-1)==' '){
            while (s.charAt(b-1)==' '){

                b--;
                count1=b;
            }
            for (int i = b-1;  s.charAt(i) != ' '; i--) {
                char c = s.charAt(i);
                count++;
                 if(i<=0){
                    break;
                }
            }
            return count;
        }
else{
            for (int i = b-1;  s.charAt(i) != ' '; i--) {
                char c = s.charAt(i);
                count++;
                if(i<=0){
                    break;
                }
            }
            return count;
        }
    }
}