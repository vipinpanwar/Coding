import java.util.*;

/**
 * 
 *  Tower Construction Problem.
 *  Solution : First this is a very good problem , and this is a water fill or rain fall
 *             problem . In this problem best thing is visualise or make the few examples 
 *             on paper. 
 * 
 * 
 */

public class HackerRankTowers {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        /**
         * The idea of this problem is store x axis on TreeMap Because , we want
         * Sorted x-axis, And if one x-axis contains many y-axis , then we also
         * want that y-axis also sorted , so we will Use TreeMap and TreeSet
         *  DataStructure.
         * 
         */
        
        TreeMap<Integer, TreeSet<Integer>> xy = new TreeMap<>();
        int x[] = new int[n];
        int y[] = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int xvalue = x[i];
            int yvalue = y[i];
            if (xy.get(xvalue) == null) {
                TreeSet<Integer> t = new TreeSet<>();
                t.add(yvalue);
                xy.put(xvalue, t);
            } else {
                TreeSet<Integer> t = xy.get(xvalue);
                t.add(yvalue);
                xy.put(xvalue, t);
            }
        }
        // int size = xy.size();
        /**
         * Now this problem can be solved by line sweep so we need to swipe from left to 
         * rigth ans stop and highest y axis, repeat this sweep but this time stop in 
         * lowest y-axis.. For right to left Sweep , we will do the same .
         * 
         * We can think of  here we want to know how many cells we can fill with water 
         * and this thing we need to do for upperside aswell as for lower side also.
         * 
         * Below we get top and bottom of every x-axis, and then we will get the highest and lowest
         * y-axis up to where we need to sweep.
         * 
         */
        ArrayList<Long> top = new ArrayList<>();
        ArrayList<Long> bottom = new ArrayList<>();

        for (Integer key : xy.keySet()) {
            TreeSet<Integer> t = xy.get(key);
            long y1 = t.last();
            long y2 = t.first();
            top.add(y1);
            bottom.add(y2);
        }
        
        int topIndex = Math.abs(top.indexOf(Collections.max(top)) - 0);
        int lowIndex = Math.abs(bottom.indexOf(Collections.min(bottom)) - 0);

        // System.out.println("topi : "+topIndex+" lowI : "+lowIndex);
        for (int i = 1; i <= lowIndex; i++)
            bottom.set(i, Math.min(bottom.get(i - 1), bottom.get(i)));
        for (int i = 1; i <= topIndex; i++)
            top.set(i, Math.max(top.get(i - 1), top.get(i)));
        for (int i = xy.size() - 2; i >= lowIndex; i--)
            bottom.set(i, Math.min(bottom.get(i + 1), bottom.get(i)));
        for (int i = xy.size() - 2; i >= topIndex; i--)
            top.set(i, Math.max(top.get(i + 1), top.get(i)));
        /**
         *  Why we are subtracting 'n' from answer?
         * 
         * Look after filling towers , we will calculate whole number of cells which 
         * is present, We subtract(top - bottom) to calculate the number of cell in each 
         * x-axis , so finally we have total number of cells after constructing the towers 
         * , Now we need to know how many towers we constructed , for this we will simply subtract
         * 
         * ( totalTowers  - initialTowers);
         * 
         * 
         * 
         */
        long ans = -n;
        // top.forEach((o)->{System.out.println("toparray : "+o);});
        // bottom.forEach((o)->{System.out.println("bottomarray : "+o);});

        for (int i = 0; i < top.size(); i++) {
            ans += top.get(i) - bottom.get(i) + 1;
        }

        System.out.println(ans);

    }
}