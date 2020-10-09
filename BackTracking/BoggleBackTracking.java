import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 *  problem : https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/ ;
 *  
 *  Solution : This is a recursion problem , here we can go to all the eight positions,
 *            so make x and y axis array , globally. 
 * 
 *          BC : Very Very Important ; 
 *          // Here base Condition is when word length is equal to cells in the matrix simply returns;
 * 
 *          choice diagram or hypothesis;
 * 
 *          solve(Boggle[][] , auxillary [][] , String word , arrayList dictionary , row , col )
 *      
 *          
 *          // we have make one matrix same as given , where all cells are false initially
 *          // iterate the for all eight direction and see if the x&y axis are valid, if yes
 *          // include the characrer to the word, 
 * 
 *          {
 *          if(dictionary.contains(word)) print(word);
 *          if(word.length() == (#_of_cells)) return;
 *          //choice diagram
 *          for ( int i=0 ; i < 8 ; i++){
 *             
 *          int x = row + x[i];
 *          int y = col + y[i];
 *          if(isValid ( row , col)){
 *             auxilary[row][col] = true;
 *             solve(boggle , auxillary , word + boggle[row][col] , x , y)
 *             auxilary [row][col] = false;
 *          }
 *          }
 *          }
 * 
 *          
 * 
 * 
 * 
 */

public class BoggleBackTracking {

    static int auxilary[][];
    static final String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" , "GIES"}; 
    static final ArrayList<String> list = new ArrayList<>( Arrays.asList(dictionary));

    static int[] x = new int[] { 0, 0, 1, 1, -1, 1, -1, -1 };
    static int[] y = new int[] { 1, -1, -1, 1, 1, 0, 0, -1 };
   
   static boolean isValid(int x , int y , int row , int col){
    if(x >= 0 && y >= 0 && x < row && y < col && auxilary[x][y] == 0)
        return true;

    return false;
   }
   
    static void solve(char [][] boggle , int [][]auxilary , String word , int row ,int col){

        
        if( list.contains(word)){
                System.out.println(word);
        }
        if( word.length() == (boggle.length * boggle[0].length)){
            return ;
        }

        for (int i = 0; i < 8; i++) {
            int rowNew = row + x[i];
            int colNew = col + y[i];

            if( isValid( rowNew , colNew , boggle.length , boggle[0].length)){
               // if(auxilary[rowNew][colNew] == 1) continue;
                auxilary[rowNew][colNew] = 1;
                solve(boggle, auxilary, word + boggle[rowNew][colNew], rowNew, colNew);
                //imp step is below
                auxilary[rowNew][colNew] = 0;
            }


        }



    }

    public static void main(String[] args) {
        
        char boggle[][] = { { 'G', 'I', 'Z' ,'A' }, 
                            { 'U', 'E', 'K' , 'B' }, 
                            { 'Q', 'S', 'E' , 'E' } }; 
       
        System.out.println(boggle.length * boggle[0].length);
        auxilary = new int[boggle.length][boggle[0].length];
        String word = "";
        System.out.println("Following words of dictionary are present");
        for (int i = 0; i < auxilary.length; i++) {
            for (int j = 0; j < auxilary[0].length; j++) {
                auxilary[i][j] = 0;
            }
        }
        for ( int i = 0; i < boggle.length; i++) {
            for (int j = 0; j < boggle[0].length; j++) {
                auxilary[i][j] = 1;
                solve(boggle , auxilary , word + boggle[i][j] , i, j ); //why not i and j , it does not matter , both can give multiple answer
                //solve(boggle , auxilary , word + boggle[i][j] , 0, 0 ); 
                [i][j] = 0; 
            }
        }
       //list.forEach(p -> System.out.println(p));
    }
}
