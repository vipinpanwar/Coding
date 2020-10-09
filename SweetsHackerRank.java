
import java.util.*;


class Sweet implements Comparable{
    public Long key;
    public Long value;

    @Override
    public int compareTo (Object sweet) {
        //int compareage=((Student)comparestu).getStudentage();
        Sweet s=new Sweet();
        s=((Sweet)sweet);
        Long key=s.key;
        /* For Ascending order*/
        //return this.studentage-compareage;
        Long x= (this.key-key);
        if(x==0) return 0;
        if(x>0)return 1;
        return -1;

        /* For Descending order do like this */
        //return compareage-this.studentage;
 
    }

}


public class SweetsHackerRank {

  
    static Scanner sc=new Scanner(System.in);

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
//Map<Long,Long> map=new LinkedHashMap<>(); Do not sort key or value by default.
   ArrayList<Sweet> sweetList = new ArrayList<Sweet>(); //sort keys by red bblack tree algorithm.
  
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            Sweet sweet=new Sweet();
               
            sweet.key=sc.nextLong();
            sweet.value=sc.nextLong();
            sweetList.add(sweet);
           
        }
       // sweetList.sort();
        Collections.sort(sweetList);

     //  sweetList.forEach((Sweet x)->{  System.out.println(x.key+"  "+x.value);});
     //System.out.println(sweetList.size());
        PriorityQueue<Long> pQueue = new PriorityQueue<Long>(); 

       // map.forEach((key,value)->{});
       Long min_candies=0l;
       int max_student=0;

       for(Sweet s:sweetList){
           
              Long key=s.key;
              Long value=s.value;
              pQueue.add(value);
               while(pQueue.size()>0 && key>(pQueue.peek())){
                  // System.out.println("hello");
                   pQueue.poll();
                  
                   
               }
             //  pQueue.forEach(((x)->System.out.print("queue : "+x)));
               if(max_student<pQueue.size()){
              max_student=pQueue.size();
              min_candies=key;
              //System.out.println();
            }
            
           
       }
  
       System.out.println(min_candies+" "+max_student);
       System.out.println(" Test is below" );
       PriorityQueue<Integer> test = new PriorityQueue<Integer>(); 
       test.add(90);
       test.add(80);
       test.add(-10);
       test.add(8);
       test.forEach(x -> System.out.print(x + " "));
       
       
        //if( 2 > null)System.out.println( );
        
    }
}