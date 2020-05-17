public class SieveAlgo{

    //problem : to find prime numbers up to n;
    //Time Complexity : nlog(n)
    /* In order to see the time complexity we have to see how many time inner loop is executed :
     (n/2+n/3+n/5+n/7+n/11.......) This is a harmonic prime number series
     which is nlog(logn). This problem can be solve in O(n) time please see  geeksforgeeks for that.
    */



   public static void  sievePrime(int n,boolean primeUpToN[]){
   

   for(int i=2;i<=Math.sqrt(n);i++){
    if(primeUpToN[i]){
        for(int j=i*2;j<=n;j+=i){
            primeUpToN[j]=false;
        }
    }
   }
   
    }

    public static void main(String args[]) {
       int n=50;
       boolean primeUpToN[]=new boolean[n+1];
       for(int i=2;i<n;i++)
       primeUpToN[i]=true;

      
       sievePrime(n,primeUpToN);

       for(int i=0;i<n;i++)
       if(primeUpToN[i])
       System.out.println(i+"  ");

    }

}