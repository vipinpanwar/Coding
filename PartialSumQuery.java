    /*Partial sum
    *Problem : Giving the two indexes x and y you have to find the cumalitive sum of A[x] to A[y] inclusive.
    *These indexes given as a query ex Q(x1,y1),Q(x2,y2)....up to n
    *
    *Soln: In order to solve in O(Q) time where Q=number of query we have to solve each query in constant time
    *      Fot that we have to use auxillary array and save the running sum of the array in that auxillary array.
    *      Then soln for each query is Q(x,y) = Aux[y]-Aux[x-1]; Aux array should start from 1 and index 0 initalize with 0.
    */
    //array index start from 1;
import java.util.*;
 class PartialSumQuery{

    static void partialSum(int auxArray[],int x,int y){
        int ans=auxArray[y]-auxArray[x-1];
        System.out.println("Ans : "+ans);


    }

    public static void main(String[] args){
        int n=5;
        int inputArray[]=new int[n+1];
        Scanner sc=new Scanner(System.in);
        for(int i=1;i<n+1;i++){
            inputArray[i]=sc.nextInt();
        }
        sc.close();
        int auxArray[]=new int[n+1];
        auxArray[0]=0;
        for(int i=1;i<n+1;i++)
        auxArray[i]=auxArray[i-1]+inputArray[i];  
        int x=2;
        int y=5;
        partialSum(auxArray,x,y);

    }


 }