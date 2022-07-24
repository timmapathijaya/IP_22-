class Solution {
    public void sieveOfEratosthenes(int M , int N , ArrayList<Integer>prime)
    {
        boolean isPrime[] = new boolean[N + 1];
        for(int i = 2 ; i < N+1 ; i++)
        isPrime[i] = true;
        for(int i = 2 ; i * i <= N ; i++)
        {
            if(isPrime[i]){
                for(int j = i * 2 ; j <= N ; j += i)
                isPrime[j] = false;
            }
        }
        for(int i = M ; i <= N ; i++)
        {
            if(isPrime[i])
            prime.add(i);
        }
    }
    // TC : O(nloglogn)
    // SC : O(n)
    
    ArrayList<Integer> primeRange(int M, int N) {
       ArrayList<Integer> prime = new ArrayList<>();
       sieveOfEratosthenes(M,N,prime);
       return prime;
    }
}
