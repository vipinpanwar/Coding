
/*
There are n beads placed in a single line horizontally. One small letter [a-z] is written on each of them.

Find the smallest lexicographical string that can be formed by performing pick-place operation any number
 of times and print the obtained string

A pick-place operation is described as follows :-

"You are allowed to pick any one of the first K(1<=K<=n-1) beads, and place it at the end of the line."
(For Example :- If K=2, then you are allowed to pick either the first bead or the second bead and place
 it at the end.)

The string is read starting from the character on the first bead and ending at the character on the last bead.

For example, if S = "anubhaw", then, character 'a' is written on the first bead, character 'n' is written 
on the second bead, and so on.

Note:

The smallest lexicographical string from a set of strings is the string which will occur first in an English 
dictionary

Input format:

The first line contains N representing the number of sequences of beads.

Then each of the N lines contain an integer K and a string S separated by space, where each character in the
 string represents the characters written on the beads in line.

Read the inputs from the standard input stream

Constraints:

1<=N<=10^4

2<=|S|<=10^3

Output format:

Print N lines where each line contains the smallest lexicographical string that can be formed by performing 
pick-place operations any number of times

************************************Solution*********************************************
a. Important thing to observe is when k>1 we can sort the string, by doing operations.
  >>How can we sort the string when k>1?
  ans: step1: place the character after that character , after which it is supposed to be come
       ex: bhxfaui , Here first place the 'b' character after 'a', then 'i' after'b' repeat this 
       step and we will get the sorted string 
b. Second important thing which we observe is istead of moving character to last and then finding the 
   minimum lexographical string we can do following step
   >> we should append the same string to it self;
   >> then we start selecting the substring and find the minimum for that please look at function 
      pickPlace() below.


*/
import java.util.*;
public class LexicographicalString {
    static String pickPlace(String beds,int k){
        int n=beds.length();
        String min=beds;
        String ops;
       String combineBeds=beds+beds;
        for(int i=0;i<n;i++){
            ops= combineBeds.substring(i, beds.length()+i);
            min=min.compareTo(ops)>0?ops:min;
        }
        
        return min;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n!=0){
            n--;
            int k=sc.nextInt();
            String str=sc.next();
            char charArray[]=str.toCharArray();
            if(k>1){
                Arrays.sort(charArray);
                System.out.println(new String(charArray));
            }
            else
            // System.out.println(pickPlace(charArray.toString(),k));
            System.out.println(pickPlace(str,k));
        }

        // String str="Hello";
        // System.out.println( str.substring(0,5));



    }

}