class Prob27UniqueBST {
    public int numTrees(int n) {
        return uniqueBST(n ,new HashMap<Integer,Integer> ());
    }
    private int uniqueBST(int n , HashMap <Integer,Integer> memo){
        
        if(n==0 || n==1)
            return 1;
        
        int memoKey=n;
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        int ans=0;
        for(int i=0;i<n;i++){
            
             int num1 = uniqueBST(i,memo);
             int num2=uniqueBST(n-i-1,memo);
             ans+=num1*num2;
                
            
        }
        memo.put(memoKey,ans);
        
        return memo.get(memoKey);
    }
}
