/**
 * There is two problem which are common only sight change..
 * 
 * First 1: Find the count of subsets whose difference is exactly n;
 *  ex: diff =1 , arr=[1,1,2,3]
 *  ans : s1={2,1,1} s2={3}  s1-s2=1  
 *      or {3,1}-{2,1}=1
 *   or{3,1}-{2,1}=1 here count is 3 and both 1 are treated independently;
 * 
 *      If we approach the problem then we have to calculate the 
 *    sum(s1) - sum(s2) = diff
 *    sum(s1) + sum(s2) = arraySum
 *     
 *   sum1(s2)+diff+sum(s2)=arraySum
 *   2sum(s2)+diff=arraySum
 *   
 *   Here we have the diff and arraySum so we can calculate the sum(s2)
 *      
 *   that is : sum(s2)=(arraySum-diff)/2;
 *  
 *   Now the problem is we have to calculat the count of sum(s2);
 * 
 * >>  Another problem is Target Sum which is similar to above problem :
 *  problem we have given an array[] and we can change any element sign to 
 *  +ve or -ve in order to get target sum. return the number of number of ways
 *  or(total count ) in which we can get the target sum;
 * 
 *  ex : arr[]={1,1,2,3} sum=1;
 * 
 *  1.) -1+1-2+3 =1
 *  2.) +1-1-2+3=1
 *  3.) 1+1+2-3=1
 *    Here count is 3;
 * 
 *  Here we can approach like we are dividing the array into two subsets
 *   First s1(containg all +ve number )
 *  second s2(contain all -ve number)
 * 
 *  so it is like s1-s2;
 *  Now this problem become similar to the above one...
 * 
 *  Only thing is If (arraySum+targetSum%2!=0) we cannot divide the array to get 
 *  the targetSum. 
 *     
 * 
 */

public class TargetSumAndDifference {

    static int countSubset(int arr[] , int n, int sum){
        int dp[][]=new int[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) 
        for (int j = 0; j < dp[0].length; j++) 
        dp[i][j]=0; 

        for ( int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                
                if(i==0) dp[i][j]=0;
                if(j==0) dp[i][j]=1;
               
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                 else
                 dp[i][j]=dp[i-1][j];   
            }
        }



        return dp[n][sum];
    }
    public static void main(String[] args) {
        
        int arr[]=new int[]{6 , 9};
        int sum=0;
        int diff=3;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        int s2=(sum-diff)/2;
        
       
        //imp condition  //  diff of two off number always odd , if sum is odd and diff is odd then odd 
        //        odd + odd is even , second codition diff of even is always even , if sum is even
        // and diff is even that even + even is always even the reason for below condtion.  
        if((sum+diff)%2!=0)
           System.out.println("cannot obtain any subset fot this difference");
           else
            System.out.println("Answer is : " +countSubset(arr, arr.length, s2)+"  s2 : "+s2);

    }
}