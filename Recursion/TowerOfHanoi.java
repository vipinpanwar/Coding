/**
 *   Problem : We have three poll (source , destination  , helper).
 *              In source poll we have n disks in ascending order(from top to down).
 * 
 *              We have to move all the disks from source to destination with the help of
 *              helper poll.
 *              imp condition : while moving the disks we can place bigger disk on the smaller disk .
 *      Here the disk which is in lowest position is 1 and disk which is above or highest position is n,
 * 
 *     Soln : it it recursion problem , and we have to just think in a recursion way.
 *      BC
 * //Smaller valid input when n=1 ;
 *      In this case we have to move disk directly from source to destination.
 *  Choice diagram :
 *      In rest of the case we should move (n-1 disk)  from source to helper and then from helper to destination.
 *                                                         or
 *         if have n disks we have to move n-1 disks to helper inorder to move last disk to destination.
 *       
 *  solve( s , h , d, n-1); here helper become destination and vice verse, 
 *  print(moving n , from s -> helper);
 *      // At last we have to move disks from helper to destination.
 *     solve(h , d ,s , n-1);
 *     print("moving n , form h -> d");
 *      
 *      
 * 
 * 
 * 
 *       so let say we have function 
 *          Solve(s , d , h , n){
 *         //bc
 *      if(n == 1){
 *          //Which means we have only one disk left, which we can move from s -> d without taking help from helper.
 *          print("moving n , from s -> d");
 *          }
 *      
 * 
 * 
 *          }
 * 
 * 
 * 
 * 
 */
public class TowerOfHanoi {
    static void solve(String s , String d, String h , int n){

        if(n == 1){
            System.out.println("moving "+ n + " from " + s + " to " + d);
            return;
        }
       
      
        solve( s, h ,d ,n-1);
        
        System.out.println("moving "+ n + " from " + s + " to " + d);
     
       
       
       
         solve(h , d ,s ,n-1);
       return;                   
      
       
        //return;

    }
    public static void main(String[] args) {

        String s = "source";
        String d = "Destination";
        String h = "Helper";
        int n = 20;
        solve(s , d , h , n);
    }
}
