class Solution {
    public int numSteps(String s) {
        int size = s.length(), steps = 0, carry = 0;
        for(int indx = size - 1; indx > 0; indx--){
            if(((s.charAt(indx) - '0') + carry) == 1){
                steps+=2;
                carry = 1;
            }else{
                steps++;
            }
        }
        return steps + carry;
    }
}