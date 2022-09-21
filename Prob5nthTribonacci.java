class Prob5nthTribonacci {
    public int tribonacci(int n) {
        return nthTribonacci(n,new HashMap<Integer,Integer> ());
    }
    private int nthTribonacci(int n , HashMap<Integer , Integer> memo){

    if(n == 0)
        return 0;
        
    if(n == 1 || n==2)
        return 1;
        
    int memoKey = n;
    if(memo.containsKey(memoKey))
        return memo.get(memoKey);
        
    int num1=nthTribonacci(n-1,memo);
     int num2=nthTribonacci(n-2,memo);
        int num3=nthTribonacci(n-3,memo);
        
        memo.put(memoKey,(num1+num2+num3));
        
        return (memo.get(memoKey));
    
    }
}
