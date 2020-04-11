import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

   
   
    public static void addNumbers(int number,PriorityQueue<Integer> lowers,PriorityQueue<Integer>highers) {
        if(lowers.isEmpty()||number<lowers.peek())
            lowers.add(number);
        else {
         highers.add(number);    
        }     
    }
    public static void rebalance(PriorityQueue<Integer> lowers,PriorityQueue<Integer>highers) {
        PriorityQueue<Integer> biggerHeap=lowers.size()>highers.size()?lowers:highers;
        PriorityQueue<Integer> smallerHeap=lowers.size()>highers.size()?highers:lowers;
        if(biggerHeap.size()-smallerHeap.size()>=2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }
    
    public static double getMedian(PriorityQueue<Integer> lowers,PriorityQueue<Integer>highers) {
        PriorityQueue<Integer> biggerHeap=lowers.size()>highers.size()?lowers:highers;
        PriorityQueue<Integer> smallerHeap=lowers.size()>highers.size()?highers:lowers;
        if(biggerHeap.size()-smallerHeap.size()==0) {
            return ((double)biggerHeap.peek()+smallerHeap.peek())/2;
        }
        else {
            return biggerHeap.peek();        
        }
    }
    public static double[] getMedians(int [] array) {
    PriorityQueue<Integer> lowers=new PriorityQueue<Integer>(new Comparator<Integer>() {
                public int compare(Integer a,Integer b) {
                return -a.compareTo(b);
                }});
    PriorityQueue<Integer> highers=new PriorityQueue<Integer>();
    double[] medians=new double[array.length];
    for(int i=0;i<array.length;i++) {
     addNumbers(array[i],lowers,highers);
     rebalance(lowers,highers);
     medians[i]=getMedian(lowers,highers);
        
    }
    
    return medians;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n =scanner.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=scanner.nextInt();
     double[] medians=  getMedians(arr);
     for(int i=0;i<medians.length;i++){
         System.out.println(medians[i]);
     }

}
}
