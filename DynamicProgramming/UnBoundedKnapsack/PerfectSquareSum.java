
/**
 *  Problem : Given a positive integer n, find the least number of 
 * perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1 : Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * *********************approach*****************************************
 *  >> we can think of from given number either we can go
 *    n-1^2 , or n-2^2...n-i^i until this is >=0
 *   then we are repeating these steps so for other numbers also
 *   so this problem has repeating substructure and optimal property
 * 
 * what ever n is we need to subtract the perdfect square from that number 
 * ex n=12 : 1--------------------------------------------------------12
 *    now if start from end (12) subtract 1^2 from it then number of steps is
 *    1 + total number of steps upto (12-1^2)11
 *  
 *    if we subtract 2^2 from 12 then the number of steps is
 *    1 + total number of stes(12-2^2) which is 8;
 * 
 *    similarly for others number i until i*i<=12
 *     edge cases : for 0,1,2 and 3 we need 0,1,2,3 steps; 0=0^0, 1=1^2 2=1^2+1^2, 3=1^2+1^2+1^2;
 *   so for 0 we return 0 , for 1 we return 1 , for 2 we retrurn 2 , for 3 we return 3
 *   for rest of the cases we Inside for loop -> ans = min(solve(n-i*i))
 *                                    tree should look like this : n=8
 *             
 *                                     8
 * 
 *                               7           4
 * 
 *                         6        3    3       0
 * 
 *                    5       2
 *               
 *                4      1
 *            3      0
 * 
 *   In the above tree we can see many number are repeating , for whcih we are calculating
 *   so many times , we can use memorization technique here and optimize it.
 *       
 * 
 */

public class PerfectSquareSum {

    static int solve(int i, int perfect[]) {

        if (i <= 3)
            return perfect[i];
        if (perfect[i] != Integer.MAX_VALUE)
            return perfect[i];

        for (int j = 1; j * j <= i; j++) {
            perfect[i] = Math.min(solve(i - j * j, perfect) + 1, perfect[i]);

        }

        return perfect[i];

    }

    static public int numSquares(int n) {
        int k = 0;
        if (n <= 3)
            k = 5;
        else
            k = n;
        int perfect[] = new int[k + 1];

        perfect[0] = 0;
        perfect[1] = 1;
        perfect[2] = 2;
        perfect[3] = 3;

        for (int i = 4; i <= n; i++) {
            perfect[i] = Integer.MAX_VALUE;
            solve(i, perfect);

        }
        return perfect[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(n);
    }
}