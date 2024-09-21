class Solution {

    public void solve(int startNum,int n,List<Integer>list){
        if(startNum > n)  return ;
        list.add(startNum);
        for(int append=0;append<=9;append++){
            int newNum = startNum*10+append;
            if(newNum > n)  return;
            solve(newNum,n,list);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer>list = new ArrayList<>();
        for(int startNum=1;startNum<=9;startNum++) 
          solve(startNum,n,list);
        return list;
    }
}