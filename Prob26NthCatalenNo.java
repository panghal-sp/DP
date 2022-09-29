class Prob26NthCatalenNo
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        return nthCtalanNo( n , new HashMap<Integer,BigInteger> ());
        
    }
    
    private static BigInteger nthCtalanNo(int n , HashMap <Integer,BigInteger> memo){
        if(n==1 || n==0)
        return BigInteger.ONE;
        
        int memoKey = n;
        if(memo.containsKey(memoKey))
        return memo.get(memoKey);
        
        BigInteger ans = BigInteger.ZERO;
        
        for(int i = 0 ; i<n ; i++){
            ans=ans.add(nthCtalanNo(i,memo).multiply( nthCtalanNo(n-i-1,memo)));
        }
        memo.put(memoKey,ans);
        
        return ans;
    }
}
