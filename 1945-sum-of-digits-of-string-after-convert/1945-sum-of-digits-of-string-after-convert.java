class Solution {
    public int getLucky(String s, int k) {
       int length=s.length();
       int sum=0;
       int stOfAlpha=96;
       for(int i=0;i<length;i++)
       {
         int temp=s.charAt(i)-stOfAlpha;
         while(temp>0)
         {
            int rem=temp%10;
            sum+=rem;
            temp/=10;
         }
       }
       k--;
       int num=sum;
       for(int i=1;i<=k;i++)
       {
         sum=0;
         int temp=num;
         while(temp>0)
         {
            int rem=temp%10;
            sum+=rem;
            temp/=10;
         }
         num=sum;
       }
       return sum;

    }
}