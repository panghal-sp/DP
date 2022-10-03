class Prob30MinPathSum {
    public int minPathSum(int[][] grid) {
        return minSum(0,0,grid,new HashMap <String , Integer>());
        
    }
    private int minSum(int currentRow , int currentCol , int [] [] grid , HashMap <String,Integer> memo ){

        if(currentRow == grid.length-1 && currentCol == grid[0].length-1)
            return grid[currentRow][currentCol];
        
        if(currentRow >= grid.length || currentCol >= grid[0].length)
            return 10001;
        
        String memoKey=currentRow+"-"+currentCol;
        
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int downMove=grid[currentRow][currentCol]+minSum(currentRow+1,currentCol,grid,memo);
        int rightMove = grid[currentRow] [currentCol]+minSum(currentRow,currentCol+1,grid,memo);
        
        memo.put(memoKey,Math.min(downMove,rightMove));
        
        return memo.get(memoKey);
    
    }
}
