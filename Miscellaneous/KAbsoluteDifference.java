import java.util.Arrays;

/**
 *  Problem : We are given an array of size n containing positive integers.
 *  The absolute difference between values at indices i and j is |a[i] – a[j]|.
 *  There are n*(n-1)/2 such pairs and we are asked to print the kth (1 <= k <= n*(n-1)/2) 
 *  smallest absolute difference among all these pairs.
 * 
 *  example : Input  : a[] = {1, 2, 3, 4}
 *        k = 3
 *      Output : 1
 *       The possible absolute differences are :
 *       {1, 2, 3, 1, 2, 1}. or { 1 , 1 , 1 ,2 ,2 ,3}
 * 
 * Soln L ::  For worst case approach we can count the absolute difference inside one 
 *            vector or array let say range of element is 1 to 10^6 then we can create one 
 *            array count[10e^6] and we count the diff to this count array count[arr[i]-arr[i-1]]++;
 * 
 *            once count array is done we have do the running sum on count array and if sum > k then return i
 *             else -1;
 * 
 * 
 */

public class KAbsoluteDifference {

   static int solveWorst(int arr[] , int k){
        int count[] = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                count[ Math.abs( arr[i] - arr[j] ) ]++;
            }
        }
        int sum = 0;

        for (int i = 0; i < count.length; i++) {
            sum+=count[i];
            if(sum >= k)
             return i;
        }
        return -1;
    }

    /**
     *  This is very important and good way to find the number of pairts less than equal to m in a
     *  linear time when array is sorted.
     *  
     *  The idea is skip the number whose absolute diff is > mid and include only which is <= to mid;
     * 
     * 
     * @param arr
     * @param mid
     * @return
     */
    static int pairs_less_than_equal( int arr[] , int mid){
        int count = 0;
        for (int i = 1 , j = 0; i < arr.length; i++) {
          while( j < i && (arr[i] - arr[j]) > mid) 
          j++;
          count += i - j;
        }

        return count;
    }



/**
 *  Efficient method here the idea is find the lowest abs diff and highest abs diff then we know that our
 *  Kth smallest diff lie b/w the lowest and highest abs difference, then we do binary search in the binary search
 *  int the given arr where we have to find
 *   if ("number of pairs less than or equal to( mid) " >= K) 
 *     right = mid;
 *   else left = mid  + 1;
 * 
 * @param arr
 * @param k
 * @return
 */
    static int solve(int arr[] , int k){
        Arrays.sort(arr);
        int left = 0;
        int right = arr[arr.length - 1] - arr[0];

        while(left < right){
            int mid = left + (right - left) / 2;
            if(pairs_less_than_equal(arr , mid) >= k){
                right = mid;
            }
            else
            left = mid + 1;
        }

        return left;
        // return right; both are correct
    }


    public static void main(String[] args) {
        int arr[] = new int [] { 2 ,3 , 1};
        int k = 1;
       System.out.println("Answer worst : " + solveWorst(arr, k) );
       System.out.println("Answer efficient : " +  solve(arr, k) ) ;


    }
}
