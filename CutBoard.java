import java.lang.reflect.Array;
import java.util.*;

public class CutBoard {
    static void solve(int rows, int cols, int x, int y) {

        if ((rows* cols- x - y) % 2 != 0) {
            System.out.println("NO");
            return;
        }

        int flag = 0;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int s = 1;
        int c = 0;
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();

        li.add(new ArrayList<>(Arrays.asList(0,cols, 1)));
        li.add(new ArrayList<>(Arrays.asList(cols- 1, -1, -1)));
        // System.out.println(res);
        ArrayList<Integer> axis = new ArrayList<>();
        for (int i = 0; i < rows; i++) {

            if (i != 0 && axis.size() == 0)
                s = ((rows- i) % 2 == 0) ? 1 : 0;
            else
                s = s == 1 ? 0 : 1;// s=1-s;
                // For 0 it goes left to right , for 1 it goes right to left

            for (int j = li.get(s).get(0); j != li.get(s).get(1); j += li.get(s).get(2)) {

                if (c >= x && c < (rows* cols- y)) {
                    if (j >= cols- y && i == rows- 1)
                        flag = 1;
                    axis.add(i + 1);
                    axis.add(j + 1);

                    if (axis.size() == 4) {
                        // System.out.println("hello2");

                        res.add(new ArrayList<>(axis));
                        axis.clear();
                    }

                }
                c++;
            }

        }

        if(flag==1) System.out.println("NO");
        else {
                    
        System.out.println("YES");
        System.out.println(res.size());
            
        res.forEach(o -> {
            o.forEach(p -> {
                System.out.print(p + " ");
            });
        System.out.println();});
    }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows= sc.nextInt();
        int cols= sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
    solve(rows,cols, x, y);
     /// List list =  new ArrayList<>(Arrays.asList(cols- 1, 0, null) );
      //list.forEach(p -> System.out.print("->  " +p + " "));
    }
}