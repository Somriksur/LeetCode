class Solution {
    public String reverseParentheses(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && ch==')'){
                StringBuilder temp=new StringBuilder();
                while(st.peek()!='('){
                    temp.append(st.pop());
                }
                st.pop();
                String t=temp.toString();
                for(int j=0;j<t.length();j++){
                    st.push(t.charAt(j));
                }
            }else{
                st.push(ch);
            }
        }
         StringBuilder sb=new StringBuilder();
         while(!st.isEmpty()){
            sb.insert(0,st.pop());
         }
         return sb.toString();
    }
}