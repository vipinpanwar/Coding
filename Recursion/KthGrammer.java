/**
 * 
 *  Leetcode problem :
 *  N=1 
 *  return 0 
 * 
 *  base condition : think of the smallest  valid input.
 *   When n = 1 , return 0;
 *  
 * 
 * choice diagram : 
 *    in a string we have two choice 
 *    for 0 replace it with : 01 
 *   for 1 replace it with : 10
 *             
 * 
 *          str = "0";
 *         solve( str ,n , m){
 *          if(n == 1 || n == m) 
 *              return str;
 *         
 *          String str2 = "";
 *          for( int i=0 ; i< str.lenegth() ; i++){
 *              if(str[i] == 0)
 *              str2 += "01";
 *              else
 *              str2 += "10";
 *          }      
 *          
 *          solve(str , n ,m+1);
 * 
 *          }
 * 
 * 
 *    0
 *    01
 *    0110
 *    01101001
 *    01101001|10010110
 *    01101001|10010110|10010110|01101001  
 * 
 * 
 *    
 * 
 * 
 */

public class KthGrammer {
    public static void main(String[] args) {
        String  str = "1";
        System.out.println(str.charAt(0) - '0' );
        int i = str.charAt(0) - '0';
        System.out.println(i);
    }
    
}
