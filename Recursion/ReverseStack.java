import java.util.Stack;

/**
 *  problem : reverse the stack :
 * 
 *  Solution : How can we reverse the stack , Always think of this manner
 * 
 *    reverse(stack){
 * 
 *      }
 *      stack ={ 1 ,2 ,3 ,4 , 5} reverse(stack) = { 5 ,4 , 3  , 2 ,1}
 *       Now we have to think of like 
 *      if we get the answer for stack.size()-1 , then what will I do : 
 *      
 * 
 *      reverse(stack , n) { 1 ,2 ,3 ,4 , 5} here we remove the 5 and store it and 
 *  >> we call the funtion of smaller input reverse(stack , n-1); stack = {1 , 2 , 3 , 4}
 *      
 *   for reverse(stack , n-1) , it return reverse of { 1 ,2 ,3 ,4 } which is { 4 , 3 ,2 1}
 *   
 *  Now we have to push 5 at the bottom of the stack , not at the top : how can I do that ?
 *  
 *  >> I can write one other function insert( stack , value ) // here value is 5
 *    insert( stack , value){
 *  // base Condition
 *      if(stack.size() == 0){
 *      stack.puch(value);
 *      return ;}
 *     else {
 *      int element = stack.top(); 
 *      stack.pop();
 *      insert(stack , value );
 *      stack.push(element);
 * 
 *      }
 * 
 *  }
 * 
 *   reverse(stack , n){
 *      if(n == 0 ) return ;
 * 
 *      int element = stack.top();
 *      stack.pop();
 *      reverse(stack , n-1);
 *      insert(stack , element);         
 * 
 *      }
 *  
 */

public class ReverseStack {

    static void insert(Stack<Integer> stack , int value){
        if(stack.size() == 0){
                  stack.push(value);
                  return ;
                }
                 else {
            int element = stack.pop(); 
            insert(stack , value );
            stack.push(element); 
            }


    }
    static void reverse(Stack<Integer> stack , int n){
        if(n == 0 )
        return ;

        int element = stack.pop();
        reverse(stack , n-1);
        insert(stack, element);


    }
  public static void main(String[] args) {
      Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack , stack.size());
        stack.forEach(x -> System.out.println(x));
  }  
}
