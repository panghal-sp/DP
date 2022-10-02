class Prob28UniquePath {
    public int uniquePaths(int m, int n) {
        int [] [] DP = new int[m+1][n+1];
        Arrays.stream(DP).forEach(a->Arrays.fill(a,-1));
        return totalWays(0,0,m,n,DP);
    }
    private int totalWays(int currentRow,int currentCol , int m , int n , int [] [] DP){
        if(currentRow == m-1 && currentCol == n-1)
            return 1;
        
        if(currentRow >= m || currentCol >= n)
            return 0;
        
        if(DP[currentRow][currentCol] != -1)
            return DP[currentRow][currentCol];
        
        int rightMove = totalWays(currentRow,currentCol+1,m,n,DP);
        int downMove = totalWays(currentRow+1,currentCol,m,n,DP);
        
        DP[currentRow][currentCol]=rightMove+downMove;
        return DP[currentRow][currentCol];
    }
}
