class Solution {
    public boolean checkValidString(String s) {
        int len = s.length();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '(') st.push(i);
            else if (c == '*') st1.push(i);
            else {
                if(!st.isEmpty()) st.pop();
                else {
                    if(!st1.isEmpty()) st1.pop();
                    else return false;
                }
            }
        }

        if(!st.isEmpty()) {
            while(!st1.isEmpty() && !st.isEmpty()) {
                if(st.peek() < st1.peek()) {
                    st.pop();
                    st1.pop();
                } else {
                    return false;
                }
            }
        }

       return st.size()==0;
    }
}