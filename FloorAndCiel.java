import java.util.*;

public class FloorAndCiel {


    int binarySearch(int arr[],int l,int r,int x){
        if(r>=l) {
         int  mid=l+(r-l)/2;
         
         if(arr[mid]==x)
             return mid;
         if(arr[mid]<x)
          return   binarySearch(arr, mid+1, r, x);
         else
        return  binarySearch(arr, l, mid-1, x);
     }
         return l;
     }
 
     public static void main(String args[]) {
        FloorAndCiel ob=new FloorAndCiel();
         int arr[] = {1, 2, 2, 2, 10, 12, 19}; 
         int n = arr.length; 
         int x = 3; 
         int result = ob.binarySearch(arr, 0, n - 1, x); 
         if (result == -1) 
             System.out.println("Element not present  "+ result); 
         else
             System.out.println("Element found at index " + result); 
 
     }
 
    
}

//Nice solution by geeksforgeeks

class Main 
{ 
	/* Function to get index of 
	ceiling of x in arr[low..high]*/
	static int ceilSearch(int arr[], int low, int high, int x) 
	{ 
	int mid;	 
		
	/* If x is smaller than or equal to the 
		first element, then return the first element */
	if(x <= arr[low]) 
		return low; 
	
	/* If x is greater than the last 
		element, then return -1 */
	if(x > arr[high]) 
		return -1; 
	
	/* get the index of middle element 
		of arr[low..high]*/
	mid = (low + high)/2; /* low + (high - low)/2 */
	
	/* If x is same as middle element, 
		then return mid */
	if(arr[mid] == x) 
		return mid; 
		
	/* If x is greater than arr[mid], then 
		either arr[mid + 1] is ceiling of x or 
		ceiling lies in arr[mid+1...high] */
	else if(arr[mid] < x) 
	{ 
		if(mid + 1 <= high && x <= arr[mid+1]) 
		return mid + 1; 
		else
		return ceilSearch(arr, mid+1, high, x); 
	} 
	
	/* If x is smaller than arr[mid], 
		then either arr[mid] is ceiling of x 
		or ceiling lies in arr[low...mid-1] */
	else
	{ 
		if(mid - 1 >= low && x > arr[mid-1]) 
		return mid; 
		else	
		return ceilSearch(arr, low, mid - 1, x); 
	} 
	} 
	
	
	/* Driver program to check above functions */
	public static void main (String[] args) 
	{ 
	int arr[] = {1, 2, 8, 10, 10, 12, 19}; 
	int n = arr.length; 
	int x = 8; 
	int index = ceilSearch(arr, 0, n-1, x); 
	if(index == -1) 
		System.out.println("Ceiling of "+x+" doesn't exist in array"); 
	else
		System.out.println("ceiling of "+x+" is "+arr[index]); 
	} 
} 
