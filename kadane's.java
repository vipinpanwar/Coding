
import java.io.*; 
import java.util.*; 
  
class Kadane 
{ 
    public static void main (String[] args) 
    { 
        int [] a = {-2, -3, 4, -1, -2, -1, 5, 9}; 
        System.out.println("Maximum contiguous sum is " + 
                                       maxSubArraySum(a)); 
    } 
  
    static int maxSubArraySum(int a[]) 
    { 
        int max_sum_so_far=0;
        int max_upto_here=0;

        for(int i=0;i<a.length;i++){
            max_upto_here+=a[i];
            if(max_upto_here<0) max_upto_here=0;
            if(max_upto_here>max_sum_so_far)
            max_sum_so_far=max_upto_here;
        
        
        }






        return max_sum_so_far;

    } 
} 
