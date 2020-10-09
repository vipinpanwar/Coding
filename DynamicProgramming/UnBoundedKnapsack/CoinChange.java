import java.util.*;
//fail to solve usign memoriasation technique....
public class CoinChange {
    static long memoAmount[][]=new long[100][100];
    static long numberOfWays(int amount,int coins[] ,int n){
        
        if(amount==0) return 1;
        if(amount<0) return 0;
        if(n == 0) return 0;
        if(memoAmount[amount][n]!= 0 ) return memoAmount[amount][n];
        long ans ;
        if(amount - coins[n - 1] >= 0){
            ans = numberOfWays(amount - coins[n-1], coins , n) + numberOfWays(amount, coins, n - 1);

        }
        else ans = numberOfWays(amount, coins, n - 1);

        return memoAmount[amount][n]  = ans;
    //     for(int i=0;i<coins.length;i++){
    //         if(memoAmount[amount]==0){
    //             memoAmount[amount]+=numberOfWays(amount-coins[i], coins);
    //             //System.out.println("checkkk   "+ memoAmount[amount]+ "amouhnt "+amount);
    //         }
    //         else return memoAmount[amount];
    //     }
    //    return memoAmount[amount];

    }


    public static void main(String[] args) {
        int[] coins={1,2 , 3};
        int n = 3;
        long  ans=numberOfWays(4,coins , n);
        System.out.println("answer : "+ans + "memo "+memoAmount[3][n]);
    }
}