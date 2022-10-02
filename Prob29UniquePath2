class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int [] [] DP = new int[m+1][n+1];
        Arrays.stream(DP).forEach(a->Arrays.fill(a,-1));
        return totalWays(0,0,m,n,DP,obstacleGrid);
    }
    private int totalWays(int currentRow,int currentCol , int m , int n , int [] [] DP,int[][] obstacleGrid){
          
        if(currentRow >= m || currentCol >= n)
            return 0;
        
         if(obstacleGrid[currentCol][currentRow] == 1)
            return 0;
        
        if(currentRow == m-1 && currentCol == n-1)
            return 1;
      
        
      
        
        if(DP[currentRow][currentCol] != -1)
            return DP[currentRow][currentCol];
        
        int rightMove = totalWays(currentRow,currentCol+1,m,n,DP,obstacleGrid);
        int downMove = totalWays(currentRow+1,currentCol,m,n,DP,obstacleGrid);
        
        DP[currentRow][currentCol]=rightMove+downMove;
        return DP[currentRow][currentCol];
    }
}
