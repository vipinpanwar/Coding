import java.util.*;

public class MaximiseTheProfit {

    static Scanner sc = new Scanner(System.in);

    static long maxfn(long a, long b) {
        if (a > b)
            return a;
        return b;
    }

    public static void main(String[] args) {
       
            long n=sc.nextInt();
            long max=-10000000;
           ArrayList<Long> profit=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                profit.add(sc.nextLong());
            }
            TreeSet<Long> leftSet=new TreeSet<>();
            TreeSet<Long> rightSet=new TreeSet<>();
            
           profit.forEach(x->rightSet.add(x));
            rightSet.remove(profit.get(0));
            leftSet.add(profit.get(0));
            for (int i = 1; i < n-1; i++) {
                long pj=profit.get(i);
                rightSet.remove(pj);
                Long i1=0l;
                try{
                    i1=leftSet.floor(pj);
                }catch(Exception e){
                   
                    
                    
                }
               finally{
                   leftSet.add(pj);
               }
               // leftSet.forEach(x->System.out.println(" ls "+x));
              //  if(i==3) System.out.println(i1+"  "+profit.get(i));
             
               
               if(i1==null||i1==pj) continue;
               Long i2=leftSet.last();
             // if(i==3) System.out.println(i1+"  "+i2);
             
               Long k2=rightSet.last();
               Long k1=0l;
               try{
                k1=rightSet.ceiling(pj);}
               catch(Exception e){

               }
               if(k1==null) continue;
                if(k1==pj) k1=k2;

               long temp1=0,temp2=0,temp3=0,temp4=0;
                if(i1<pj&&pj<k1) { temp1=i1*k1*pj;}
                if(i1<pj&&pj<k2) { temp2=i1*k2*pj;}
                if(i2<pj&&pj<k1) { temp3=i2*k1*pj;}
                if(i2<pj&&pj<k2) {  temp4=i2*k2*pj;}
                long temp_max=maxfn(temp1,temp2);
                temp_max=maxfn(temp_max,temp3);
                temp_max=maxfn(temp_max,temp4);
                max=maxfn(temp_max,max);
                System.out.println("max : "+ max+ " temp_max "+temp_max +" temp1 "+temp1+" temp2 "+temp2 + " temp3 "+temp3 +" temp4"+temp4);
                leftSet.add(pj);
                 
            }
           


            System.out.println(max);

        
    
   
}
}