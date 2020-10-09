import java.util.ArrayList;
import java.util.HashSet;

class Pair{
    public int a;
    public int b;
    public Pair(int a , int b){
        this.a = a;
        this.b = b;
    }
}
public class  practice  {
   public static void main(String[] args) {

    Pair grid[][] = new Pair[3][3];
    Pair p1 =  new Pair(1,10);
    Pair p2 =  new Pair(2,20);
    grid[0][0] = p1;
    grid[0][1] = p2;


    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid.length; j++) {
            System.out.println(grid[i][j]);
            if(grid[i][j] != null){
                Pair p = grid[i][j];
                System.out.println(p.a + "  " + p.b);
            }   
        }
    }


   }

}
    
    