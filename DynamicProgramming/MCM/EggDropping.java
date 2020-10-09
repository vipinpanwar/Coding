package MCM;


/**
 *  Problem : We are given floors and eggs and we need to find out the minimum number of 
 *            eggs to find out critical/threshold floor.
 *            critical/threshold is floor after which if we drop the egg the egg start breaking.
 * 
 *  ex  : f=5 , e= 1;   
 *          Here we have only one egg so answer is f which is 5, because we have to go one by one from first floor and 
 *         in worst case min number of attempt is 5;
 *          >> We can see we have to find out the min # of attempts in worst case.
 * 
 *       f=5 , e=2 ;
 * 
 * 
 *      First we will  need to find the base condition
 * 
 *   think of smallest valid input or invalid input 
 *  ** here let think of the smallest valid input
 * 
 *  if( e == 1) return f; when we have only one eggs.
 *  if( f==0 || f==1) return f; Here when we have only 0 or 1 floor;
 * 
 * 
 *  Now main function :  
 *   here we see that we have two option one is if egg is break and other is egg does not break
 *  , as threshold floor is not given we should calculate this for every floor; 
 *      for k=1 to k=f;
 *   case 1 : when egg is break , then we have look only in the below/lower floors
 *            solve( e - 1 , k-1);
 * 
 *   case 2  : when egg does not break , then we have to look at the above floors,
 *           solve( e , f-k);
 * 
 *  When we drop the egg either of the above two options can happen.
 *           we have to look for the worst case so
 * 
 *    int temp = 1 + max( solve( e - 1 , k - 1) , solve( e , f - k) );
 *    ans = min( ans , temp);
 *      
 * 
 * 
 */
public class EggDropping {

    static int dp[][] = new int[100][100];

    static int solve( int e , int f){
        
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;
        if(dp[e][f] != -1) return dp[e][f];
        int ans=Integer.MAX_VALUE;
        for (int k = 1; k <= f; k ++) {
               int temp = 1 + Math.max( solve( e - 1 , k - 1) , solve( e , f - k) );
              dp[e][f] = ans = Math.min( ans , temp);
        }

        return dp[e][f];
    }

    /**
     * 
     * Practice this atleast three time , very important.
     * @param e
     * @param f
     * @return
     */

    static int solveBS( int e , int f){
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;
        if(dp[e][f] != -1) return dp[e][f];
        int ans=Integer.MAX_VALUE;
        int l = 1 , r = f ;

        // while(l < r)  see why this is wrong and below condition is correct.
        while(l <= r) {
            int mid = l + ( r - l )/2;
            int left = solveBS(e - 1 , mid - 1); // egg broken
            int right = solveBS( e ,  f - mid); // egg not broken

            int temp = 1 + Math.max(left, right) ;

            if( left >= right ){
                 r = mid - 1;
            }
            else {
                l = mid + 1;
            }
           dp[e][f] = ans = Math.min(ans, temp);
        }


        return dp[e][f];
    }


    
    public static void main(String[] args) {
        int e = 2;
        int f = 36;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
             dp[i][j] = -1;   
            }
            
        }
       System.out.println("Answer : "+ solveBS(e, f) );
    }
}
