import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *  Problem : You are given an array A containing N elements. You do the following step repeatedly 
 *  >> Take any 2 elements and add their absolute difference back to the array.
 * 
 *  ** Calculate the nuhmber of distinct possible values the array contains after infinite number
 *     of steps modulo 10e^9 +7
 *  Input : n then n numbers
 *      ex : i/p : 2 2 6  
 *       output : 3     
 * 
 * 
 *      i/p : 2 1 100 
 *      o/p : 100
 * 
 *      i/p : 5 1 2 3 4 5
 *      o/p : 5
 * 
 *   ex if 8 10 even and even 
 *         we can get 2 8 10 6 4
 *             2 4
 *                 2  4 2 
 * 
 *    if we have 9 11 odd and prime odd
 *         then 9 11 2 7 4 5 6 1 -11
 *   if we have 9 15 odd and odd
 *         9 15 6 3 12 
 *   if we have  5 7 prime and prime
 *         5 7 2 3 4 1 
 *    if we have  4 7  even and prime number
 *             4 7 3 1 
 *     if we have  4 11  even and prime number
 *              4 11 7 3 1
 *    if we have 6 19 even and prime 
 *         6 13 7 
 *    if we have 10 47 even and prime
 *      10 47 37 27 17 7 3 4 1 
 * 
 * 
 * 
 * 
 * 
 */

public class AbsoluteDifference {

  static void solve( Integer arr[]){

    List<Integer> diff1 = new ArrayList<>();
    List<Integer> diff2 = new ArrayList<>();
    int n = arr.length;
    Arrays.sort(arr);

    diff1 = Arrays.asList(arr);
    
    int min_diff = Integer.MAX_VALUE;

    while( (n - 1) > 0){
        n--;
        for (int i = 1; i < diff1.size(); i++) {
            int diff = diff1.get(i) - diff1.get(i-1);
        	if(diff2.size() > 0 ){
            if (diff2.contains(diff) == false)
        	diff2.add(diff);
            }
        	else diff2.add(diff);
        }
        if(diff2.contains(1)){
            min_diff = 1;
            break;
        }
        if(diff2.size() > 0)
        if(Collections.min(diff2) != 0)
        min_diff  = Math.min(Collections.min(diff2) , min_diff );
        diff1 = new ArrayList<>(diff2);
        Collections.sort(diff1);
        diff2.clear();

    }


    for (int i = 0; i < diff1.size(); i++) {
     System.out.println("Answer : " + diff1.get(i));   
    }
 System.out.println("min diff : " + min_diff);


  }
    public static void main(String[] args) {
        Integer arr[] = new Integer[] { 3};
        solve(arr);
        int i = 1000000000;
        System.out.println(i);
        
    }
}
