class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length ; 
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
            if(grumpy[i] == 0){
                sum  = sum + customers[i];
            }
        }

        int loss = 0 ;
        for(int i = 0 ; i < minutes ; i++){
            if(grumpy[i] == 1){
                loss = loss + customers[i];
            }
        }

        int maxloss = loss;
        int i = 0;
        int j = minutes;

        while(j<n){
            if(grumpy[i] == 1){
                loss = loss - customers[i];
            }
            if(grumpy[j] == 1){
                loss = loss + customers[j];
            }
            maxloss = Math.max(loss , maxloss);
            i++;
            j++;
        }

        return maxloss+sum;
    }
}