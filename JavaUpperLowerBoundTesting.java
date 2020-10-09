import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JavaUpperLowerBoundTesting {
    
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,8,20,23));

        int key=9;
        System.out.println(" index : " +Collections.binarySearch(list, key)+"  value : "+list.get(Collections.binarySearch(list, key)));


    }
}