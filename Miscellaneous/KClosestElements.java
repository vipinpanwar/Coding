import java.util.LinkedList;


/**
 * 
 *  Problem : Given a sorted array arr, two integers k and x, find the k
 *  closest elements to x in the array. The result should also be sorted in 
 * ascending order. If there is a tie, the smaller elements are always preferred.
 * 
 *  example : Input: arr = [1,2,3,4,5], k = 4, x = 3
 *           Output: [1,2,3,4]
 *     Here closest means difference....  
 *           arr = [ 1 ,3 ,8 ,9] k=2 , x =8
 *           here ans is 8 ,9 because the diff b/w 8 and 9 is  so 9 is second closest and 8 itself is closest one.
 * 
 * 
 */


public class KClosestElements {

    static int binarySearch( int arr[] , int x){

        int l = 0;
        int r = arr.length-1;
        
        while( l < r ){
            int mid = l + (r - l) / 2;
            
            if( arr[mid] > x){
                r = mid - 1;
            }
            if( arr[mid] < x){
                l = mid + 1;
            }
            else return mid;
        }

        if( Math.abs( arr[l] - x ) < Math.abs( arr[r] - x ))
         return l;
         return r;

    }
    static LinkedList<Integer> solve(int arr[] , int k ,int x){
        int index = binarySearch(arr , x);
        int left = index;
        int right = index+1;
        System.out.println("Index : " + index);
        LinkedList<Integer> ans = new LinkedList<>();

        while( k-- > 0){
            int leftValue = left >= 0 ? Math.abs(arr[left] - x) : Integer.MAX_VALUE;
            int rightValue = right < arr.length ? Math.abs( arr[right]  - x) : Integer.MAX_VALUE;

            if(leftValue <= rightValue){
                ans.addFirst(arr[left]);
                left--;
            }
            else{
                ans.add(arr[right]);
                right++;
            }


        }



        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{ 1 ,3 ,6, 8, 6, 10};
        int x = 90;
        int k = 3;
       LinkedList<Integer> ans =  solve(arr, k, x);

       ans.forEach(t-> {System.out.println( t ); });
    }
    
}
