import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *  1.) we have to sort the array using the recursion.
 * 
 *  i/p : arr : [2 , 6 ,3 ,9 , 0]
 *        o/p : [0 , 2 ,3 ,6 , 9]
 * 
 * Solution : sort(arr , n);//this will sort 1..to n;
 *            sort(arr , n-1);//this will sort 1..to n-1;
 *            .
 *            sort(arr , n-1) ; will give us sorted array up 1 to n-1 now the elment
 *              which is arr[n], we have to insert in the sorted array to make the complete array sort;
 * 
 *             
 *            now we have to think of BC;
 * 
 * BC : if size is 1 then single element is always sorted in both ways.
 *      return that element;
 * 
 *   : Now we have think of main logic...
 * 
 *   skeleton fn
 * 
 *      sort(arr , n){
 *          if(n == 1)  return arr[n];
 *          int element = arr[n];
 *          sort(arr , n-1);
 *          insert(arr , element);
 * 
 *      }
 * 
 * 
 * Now insert function
 * 
 * 
 *     insert(V , element ){
 *            if(v.size() == 0 || v[v.size() - 1]<= element)
 *          v.push_back(element);
 *          
 *          int val = v[v.size() - 1];
 *          v.pop();
 *          insert(v , element);
 *          v.push_back(val);
 * 
         
 *           }
 * 
 * 
 * 
 */

public class SortRecursion {

    static ArrayList<Integer> arrList = new ArrayList<>();
    

    static void insert(LinkedList<Integer> list , int element){
            if(list.size() == 0 || list.getLast() <= element)
             list.addLast(element);
            else {
                int lastElement = list.getLast();
                list.removeLast();
                insert(list , element);
                list.addLast(lastElement);

            }


    }


    static void sort(LinkedList<Integer> list , int n){
            //bc
        if(n == 1 || n == 0)
            return;
        int element = list.getLast();
        list.removeLast();
        sort(list , n-1);
        insert(list , element);

        //return 0;


    }

    public static void main(String[] args) {
        // int arr[] = new int[]{2  , 1 , 9 ,6};
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(2 , 1 , 9 ,6 ,0 ,100 , -11 , -9));
        sort(list , list.size() ) ;
        list.forEach(x -> System.out.println(x));

    }
    
}
