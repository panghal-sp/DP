class Prob2FiboNacci {
    public int fib(int n) {
        return nthFibo(n,new HashMap<Integer,Integer> ());
    }
    private int nthFibo(int n , HashMap<Integer,Integer> memo){

        if(n==0)
            return 0;
        if(n == 1)
            return 1;
        
        if(memo.containsKey(n))
            return memo.get(n);
        
        int a=nthFibo(n-1,memo);
        int b=nthFibo(n-2,memo);
        
        memo.put(n,(a+b));
        return a+b;
    
    }
}
