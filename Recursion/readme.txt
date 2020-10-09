Recursion : 

1.) Make input smaller by taking decision making.
2.) Decision making is a main logic.

    How to identify the Recursion : 
    1.) we will get the choice,and we have to make decision.

3.) Recursive Tree.
   Very very important, If we create the recursive tree , then 
   writing the code is cake walk.

             lets take one example 

                 i/p

         
  o/p1(smaller i/p)      o/p2(smaleer i/p) and so one

lets take subset problem : ex -> {ab}

here o/p is ,{ "" , a , b ,ab}

                                               ab (first we are in indx 0 (a)) we have two choice either take 'a' or ignore it)


            (not-included) ""("b")smaller i/p              (Included) "a" ("b") smaller i/p

           


 not-included       ""              "b"("")smaller i/p  |      "a"(not-included)("")              "ab"(not-included)("")
                

In leaf  nodes we can see input is empty , so when i/p is empty we will get our answer.     

 //    here branches represent the choices.


*********************Delete*********************
 { //middle of the stack 

   given stack : { 2 , 6 ,7 , 8 ,0} //ans = 7
                 { 2 , 5 , 4 , 1}  // ans =  5
                 
                 stack size = 5
                
                { 2 , 6 ,7 , 8 ,0}
                    // middle  = 3 , stackSize = 5;
                 stackMiddle (stack , middle){

                     if(stack.size() == middle) return stack[middle];
                     else{
                         element = stack.top();
                         stack.pop();
                         stackMiddle(stack , middle);
                         stack.push(element);
                     }

                 }



 }