import java.util.*;

/**
 *  Problem : Given an array of n elements , xoe each unordered pair and sum them all.
 * 
 *  Example  : arr[] = 5 ,9 , 7 , 6
 *           5 ^ 9 = 12;
 *           5 ^ 7 = 2
 *           5 ^ 6 = 3
 *           9 ^ 7 = 14
 *          9 ^ 6 = 15
 *         7 ^ 6 = 1
 *        Total   =    47;
 * 
 * 
 *      Brute force approach is n^2 , using two loop.
 * 
 *   Now efficient approach which is nlog(n);
 * 
 *      1.) If there are three number : 5(0 1 0 1) , 3(0 0 1 1) , 9(1 0 0 1)
 *          5 ^ 3 = 0 1 1 0
 *          5 ^ 9 = 1 1 0 0
 *          3 ^ 9 = 1 0 1 0   Total = 28, 0*2^0 + 2* 2^1 + 2*2^2 + 2*2^3 =  28
 *              
 *      Here is we can see , here # of pairs * 2^pos, 
 *    one imp observation , if we have four numbers
 *    ( 1 , 1 , 0 , 0) , In this case total number of pairs is 4 whic result to 1 when doing xor,
 *       which is # of zero * # of one,
 *    pairs ( 1 , 0) ( 1 , 0) ( 1 , 0) , ( 1, 0)
 *  
 * 
 * 
 * 
 * 
 * 
 */
public class AllPairSum {
  public static void main(String[] args) {
      int n =1;
      int arr[]  = new int[]{ 5 , 7 , 6 , 9};
        int pair = 0 , res = 0;
    for (int i = 0; i <= 6; i++) {
        int countZero = 0 ; int countOne = 0; 

        for (int j = 0; j < arr.length; j++) {
            if((arr[j] & (1 << i) ) != 0) countOne++;
            else countZero++;
           // System.out.println(" arr[j] " + arr[j] + "i " + i + " res " + (arr[j] & (1 << i) ) );
        }

       // System.out.print("zero " + countZero + "one " + countOne);
       // System.out.println();
        pair = countOne *  countZero;
       // System.out.println(pair);
        res += pair * (1 << i);
    }
    System.out.println("Answer : " + res);


    int a = 2;
    a = a | (1 << 2);
    System.out.println("Set 2 bit " + a);
      
  }  
}
