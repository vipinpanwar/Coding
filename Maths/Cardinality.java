

//import for Scanner and other utility classes
import java.util.*;


class Cardinality {

 
    static long countCardinality(int []arr ,  ArrayList<Integer> indices  , long n ){
            long finalNum = 1;
        if( indices.size() == 0 ) return 0;
        if(indices.size() == 1){
        for ( int a : indices){
            //System.out.println("a " + a);
            finalNum *= arr[a];
        }
    } else{
        int ans = 1;
        for ( int a : indices){
            // Here taking LCM
            ans = (ans * arr[a]) / (gcd(ans  ,arr[a]));
        }
        finalNum = ans;

    }
  
        return ( n / finalNum);
    }

    static int gcd( int a , int b){

        return b == 0? a : gcd( b , a%b) ;
    }
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
     
        int t = sc.nextInt();

        while(t>0){
            long res = 0;
            t--;
            int size = sc.nextInt();
            int arr[] = new int[size];
            int size2 = 0;
            HashSet<Integer> set  = new HashSet<>();
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                set.add(x);
            } 

            int p = 0 ;
            for( int x : set){
                arr[p++] = x;
            }
            long k = sc.nextLong();
            size = set.size();


            for( int i = 0 ; i < (1 <<size )  ; i++ ){
                ArrayList<Integer> indices = new ArrayList<>();
        
                 for( int j =0 ; j < size ; j++){
                    int a = (i & (1 << j));
                     if( a != 0 ){
                         System.out.println("binisde " + a + " j " + j + " i " + i );
                    
                         indices.add(j);
                     }
                 }
                //  indices.forEach(x -> System.out.print("ind " +x  + "  "));
                //  System.out.println();
                // System.out.println(" i " + i);
        
                 long cardinality = countCardinality( arr , indices , k);
                 //System.out.println("card i " +cardinality);
                
                 if( indices.size() % 2 == 0)  res -= cardinality;
                 else res += cardinality;
        
        
                }

                // for (int i = 0; i < size; i++) {
                //     System.out.println(arr[i]);
                // }
                 System.out.println(res);

        }
     
      
      


 

    }
}
