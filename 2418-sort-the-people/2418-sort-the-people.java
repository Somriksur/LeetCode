class Solution {
    public String[] sortPeople(String[] nm, int[] ht) {

        for(int i=0;i<nm.length-1;i++){
    
           for(int j=i+1;j<nm.length;j++){
               if(ht[i]<ht[j]){
              int temp = ht[i];
               ht[i]=ht[j];
               ht[j]=temp;
               String temp1 = nm[i];
               nm[i]=nm[j];
               nm[j]=temp1;
               }
           }
        }
      return nm;  
    }
}