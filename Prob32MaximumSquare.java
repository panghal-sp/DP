class Prob32MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n=  matrix[0].length;
        HashMap<String,Integer> memo=new HashMap<>();
        
        int area =0;
        
        for(int currentRow=0; currentRow < m ;currentRow++)
            for(int currentCol=0; currentCol < n; currentCol++){

            if(matrix[currentRow][currentCol] != 0){
            int side=maximumSide(matrix,currentRow,currentCol,m,n,memo);
            area=Math.max(area,side*side);
            }
            }
        return area;
    }
    
    private int maximumSide(char [][]matrix,int currentRow , int currentCol , int m ,int n , HashMap<String,Integer> memo){
        
        if(currentRow >= m || currentCol >= n || matrix[currentRow][currentCol] == '0')
            return 0;
        
        String memoKey=currentRow+"-"+currentCol;
        
        
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int downMove = 1+maximumSide(matrix,currentRow+1,currentCol,m,n,memo);
        int sideMove = 1+maximumSide(matrix,currentRow,currentCol+1,m,n,memo);
        int diagonalMove = 1+maximumSide(matrix,currentRow+1,currentCol+1,m,n,memo);
        
        memo.put(memoKey,Math.min(downMove,Math.min(sideMove,diagonalMove)));
        
        return memo.get(memoKey);
    }
}
