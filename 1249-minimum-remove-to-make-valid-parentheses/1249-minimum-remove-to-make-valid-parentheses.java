class Solution {
    public String minRemoveToMakeValid(String s) {
        
        char [] input = s.toCharArray();

        int count = 0;
        for(int i = 0 ; i < input.length ; i++)
        {

            if(input[i] == '(')
            count++;
            else if(input[i] == ')')
            count--;

            if(count < 0)
            {
                count = 0;
                input[i] = 'N';
            }
        } 


        int j = input.length - 1;
        while(count > 0 && j >= 0)
        {
            if(input[j] == '(')
            {
                input[j] = 'N';
                count--;
            }
            j--;
        }


        StringBuffer sb = new StringBuffer();
        for(char ch : input)
        {
            if(ch != 'N')
                sb.append(ch);
        }

        return sb.toString();

    }
}