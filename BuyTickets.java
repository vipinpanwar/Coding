import java.util.*;

class Person{
    Integer pos;
    Integer tickets;

}

public class BuyTickets{

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Queue<Person> q = new LinkedList<>(); 
        Integer n=sc.nextInt();
        System.out.println("enter the number of tickets per person in sequence");
        
        for(int i=1;i<=n;i++){
            Person person=new Person();
            person.pos=i;
            person.tickets=sc.nextInt();
            q.add(person);
        }
        System.out.println("enter jessica valid position : ");
        Integer pos= sc.nextInt();
        Integer timeTaken=0;
        
        while(!q.isEmpty()){
            Person person=q.remove(); 
           
            if(person.pos==pos&&person.tickets==1){
                timeTaken++;
                break;
            }
            person.tickets--;
            timeTaken++;
            if(person.tickets!=0)
            q.add(person);
    }
    System.out.println("Total time is : "+timeTaken);

    }

}