   
   /*  Problem: You have update the array for the given Queries.
    *   if Q(x,y,value) you have update array as : array[x]+value,array[x+1]+value...array[y]+value;
    *   Input: n queries. Complexity Expexted O(n)
    *   Solution : Take a auxilary array Aux; if Queries are
    *   Q1(3,6,10),Q2(2,4,-2),Q3(1,3,2), Input array range[1-6];
    *   Aux array state 1 (Initially)  Aux[0,0,0,0,0,0];   
    *   Aux array state 2 Q1(3,6,10)  Aux[0,0,10,0,0,0]; update only 3 and 6 element and add -10 on (y+1) index.
    *   in the above y=6=n this is the reason we are not adding -10 to y+1;
    *   Aux array state 3 Q2(2,4,-2)  Aux[0,-2,10,0,+2,0]; we add +2 to (y+1) index because our final step is partial sum.   
    *   Aux array state 3 Q3(1,3,2)  Aux[2,-2,10,-2,+2,0]; we add -2 to (y+1) index because our final step is partial sum.   
    *   Now we do partial sum= Aux[2,0,10,8,10,10];
    *   add this to input array with respective to indexes that's the final answer.
    */


import java.util.*;
class Query{
    int x;
    int y;
    int value;
    Query(){

    }
    Query(int x,int y,int value){
        this.x=x;
        this.y=y;
        this.value=value;

    }
}
public class RangeUpdate {
    static Scanner sc=new Scanner(System.in);

    static void upadteRangeQuery(int[] inputArray,List<Query> queries){
        int[] auxilary=new int[inputArray.length+1];
        for(Query q:queries){
            auxilary[q.x]+=q.value;
            auxilary[q.y+1]+=-(q.value);
        }
        for(int i=1;i<auxilary.length-1;i++){
            auxilary[i]=auxilary[i-1]+auxilary[i];
        }
        for (int i = 1; i < auxilary.length-1; i++) {
        System.out.println(auxilary[i]+inputArray[i]);    
        }

    }
    public static void main(String[] args){
        int n;
        n=6;
       
        int[] inputArray=new int[n+1];
        for(int i=1;i<n+1;i++){
            inputArray[i]=sc.nextInt();
        }
        sc.close();
        
        List queries=new ArrayList<Query>();
        queries.add(new Query(3,6,10));
        queries.add(new Query(2,4,-2));
        queries.add(new Query(1,3,2));

        upadteRangeQuery(inputArray,queries);





    }
    
}