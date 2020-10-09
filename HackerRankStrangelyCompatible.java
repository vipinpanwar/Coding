import java.util.*;

import javax.sound.sampled.Line;

public class HackerRankStrangelyCompatible {
    static Scanner sc = new Scanner(System.in);

    static Long noOfPairs(LinkedHashMap<String, Integer> map) {
        Long sum = 0l;
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            sum = sum + (value * (value - 1)) / 2;// hand shake (n(n-1))/2
        }

        return sum;

    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> compStrs = new ArrayList<>();
        LinkedHashMap<String, Integer> same = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> different = new LinkedHashMap<>();

        
        for (int i = 0; i < n; i++) {
            compStrs.add(sc.next());
        }
        for (String str : compStrs) {
            if (same.get(str) == null)
                same.put(str, 1);
            else
                same.put(str, same.get(str) + 1);
            StringBuilder string = new StringBuilder(str);
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                string.setCharAt(i, '!');
                String key = string.toString();
                if (different.get(key) == null)
                    different.put(key, 1);
                else
                    different.put(key, different.get(key) + 1);
                string.setCharAt(i, c);
            }

        }
        // same.forEach((key,value)->{System.out.println("key : "+key+"value +
        // "+value);});
        System.out.println(noOfPairs(different) - noOfPairs(same) * m);
        // System.out.println(noOfPairs(same));

    }
}