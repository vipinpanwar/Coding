

/**
 * Problem : In this problem we have to choose the minimum difference of two subset of an array:
 * so if arr[]={1,5,5,11}
 *       subset1{1,5,5}=11 subset2={11} absolute difference =0;
 * here we can not leave any element;
 * 
 * >> problem is similar to equal subset partition; where  s1-s2=0
 *    Here we need to find that : s1-s2=minimum;
 *  if ar[]={1,5,5,11}
 *  we have range here 0-----------half-------------22
 *  our s1 and s2 sum shoulr lie b/w 0-22;
 *  s1-s2=min or totalSum-s1=s2;  
 *  if we find s1 we can find s2 easily and s2=TotalSum-s1;
 *  problem become s2-s1 = totalSum-s1-s1 = totalSum-2s1 = min 
 *  
 *  we need to find the s1 .. and we will select s1 from 0----half
 *  or 0<=s1<=TotalSum/2
 * 
 *   if we use subsetSum and calculate the matrix then we will have to 
 *   search of s1 which will lie at the last row of that matrix.
 * 
 * 
 */
import java.util.ArrayList;

public class SubsetMinimumDiff {

    static void subsetTopDown(int arr[], int n,int sum){

        boolean  dp[][]=new boolean[n+1][sum+1];
       // step 1 initialisation
       //Arrays.fill(dp,false);
     
       for (int i = 0; i < dp.length; i++) 
           for (int j = 0; j < dp[0].length; j++) 
               dp[i][j]=false; 
   
       for (int i = 0; i < dp.length; i++) {
           for (int j = 0; j < dp[0].length; j++) {
               if(i==0) dp[i][j]=false;
               if(j==0) dp[i][j]=true;
              
           }
       }
      
   
       for (int i = 1; i < arr.length+1; i++) {
           for (int j = 1; j < sum+1; j++) {
               if(arr[i-1]<=j)
                            dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                         else
                             dp[i][j]=dp[i-1][j];
           }
       }
   
      ArrayList<Boolean> subsetsSum = new ArrayList<>();
      for (int i = dp.length-1; i < dp.length; i++) {
       for (int j = 0; j < dp[0].length; j++) {
           subsetsSum.add(dp[i][j]);
       }   
      }



      int min=Integer.MAX_VALUE;
      for (int i = 0; i <= subsetsSum.size()/2; i++) {
        //  if(subsetsSum.get(i)) System.out.println("i  " +i);
          if(subsetsSum.get(i))
            min=Math.min(Math.abs(sum-(2*i)),min);
      }
      

      System.out.println("Answer Minimum difference is : "+ min);
   
      }

    public static void main(String[] args) {

        int arr[]=new int[]{10,3,3,13,4};
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
       
        subsetTopDown(arr, arr.length, sum);

        
    }
    
}