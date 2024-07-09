class Solution {
    public double averageWaitingTime(int[][] customers) {
       long sum=customers[0][1];
        long time=customers[0][0]+customers[0][1];
        int i =1;
        while(i!=customers.length){
            sum += customers[i][1];
            if(customers[i][0]>=time){
            time=customers[i][0]+customers[i][1];
            }else{
                sum += (time -customers[i][0]);
            time += customers[i][1];
            }
            i++;
        }
        return (double)sum/customers.length;
    }
}