class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int cost = Integer.MAX_VALUE;
        int [][] memo=new int [matrix.length][matrix[0].length];
        
        for(int i = 0; i<matrix[0].length;i++){
            cost = Math.min(cost,minSum(0,i,matrix,memo));
        }
        return cost;
    }
    private int minSum(int currentRow,int currentCol,int [][] matrix,int [][] memo){
        
        if(currentCol < 0)
            return 100001;
        
        if(currentRow == matrix.length-1 && currentCol <= matrix[0].length-1)
            return matrix[currentRow][currentCol];
        
        if(currentRow >= matrix.length || currentCol >= matrix[0].length)
            return 100001;
        
        if(memo[currentRow][currentCol]!=0)
            return memo[currentRow][currentCol];
        
        int move1=0,move2=0,move3=0,ans=100001;
        for(int i=1; i<matrix[0].length;i++){
       //  move1 = matrix[currentRow][currentCol]+minSum(currentRow+1,currentCol+i,matrix,memo);
            move3=matrix[currentRow][currentCol]+minSum(currentRow+1,currentCol-i,matrix,memo);
            ans=Math.min(ans,move3);
        }
         for(int i=1; i<matrix[0].length;i++){
           move1 = matrix[currentRow][currentCol]+minSum(currentRow+1,currentCol+i,matrix,memo);
        // move3=matrix[currentRow][currentCol]+minSum(currentRow+1,currentCol-i,matrix,memo);
            ans=Math.min(ans,move1);
        }
      //  int ans=Math.min(move1,move3);
        
        memo[currentRow][currentCol]=ans;
        
        return memo[currentRow][currentCol];
        
    }
}
