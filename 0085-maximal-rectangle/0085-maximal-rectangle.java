class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] mat = new int[row][col];
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(matrix[i][j] == '1'){
                    mat[i][j] = 1;
                }else{
                    mat[i][j] = 0;
                }
            }
        }
        
        int[] curr_row = mat[0];
        int curr_sum = max_histogram(curr_row);
        
        for(int i = 1 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(mat[i][j] == 1){
                    curr_row[j] += 1;
                }else{
                    curr_row[j] = 0;
                }
            }
            int temp = max_histogram(curr_row);
            curr_sum = Math.max(curr_sum , temp);
        }
        return curr_sum;
        
    }
    
    public int max_histogram(int[] m){
        
        Stack<Integer> s1 = new Stack<>();
        int[] prev_smaller = new int[m.length];
        
        for(int i = 0 ; i < m.length ; i++){
            while(!s1.isEmpty() && m[s1.peek()] >= m[i]){
                s1.pop();
            }
            
            if(s1.isEmpty()){
                prev_smaller[i] = -1;
            }else{
                prev_smaller[i] = s1.peek();
            }
            s1.push(i);
            
        }
        
        Stack<Integer> s2 = new Stack<>();
        int[] next_smaller = new int[m.length];
        
        for(int i = m.length-1 ; i >= 0; i--){
            while(!s2.isEmpty() && m[s2.peek()] >= m[i]){
                s2.pop();
            }
            
            if(s2.isEmpty()){
                next_smaller[i] = m.length;
            }else{
                next_smaller[i] = s2.peek();
            }
            s2.push(i);
        }
        int ans = 0;
        
        for(int i = 0 ;i < m.length ; i++){
            int temp = (next_smaller[i] - prev_smaller[i]-1) * m[i];
            ans = Math.max(temp , ans);
        }
        return ans;   
    }
}