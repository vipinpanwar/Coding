import java.util.*;

import javax.smartcardio.Card;

public class RangeSumUpadateQuery {
    static void update(int[] st, int si, int sl, int sr, int index, int diff) {
        if (sl > index || sr < index)  return;
        System.out.println(" si -> "+si);
        st[si] += diff;
            if (sl!=sr) {
                
                int mid = sl + (sr - sl) / 2;
                update(st, si * 2 + 1, sl, mid, index, diff);
                update(st, si * 2 + 2, mid + 1, sr, index, diff);

            }
        

    }

    /**
     * In this fn we have three cases. case 1 : (Complete Overlap) In this case we
     * simply return the sum of that particular node. case 2 : (partial overlap) In
     * this case we call the both end left and right. case 3 : (No overlap) return
     * 0.
     * 
     * @param st (segment tree array)
     * @param si (to track the st nodes)
     * @param sl (pointing to starting of st nodes range)
     * @param sr (reference to end of st nodes range)
     * @param l  (starting of Query range)
     * @param r  (ending of Query range)
     * @return (Total sum of given range(l,r))
     */
    static int getSum(int st[], int si, int sl, int sr, int l, int r) {

        if (sl > r || sr < l) {// No overlap case.
            return 0;
        }

        if (sl >= l && sr <= r) {
            return st[si];
        }

        int mid = sl + (sr - sl) / 2;

        return getSum(st, si * 2 + 1, sl, mid, l, r) + getSum(st, si * 2 + 2, mid + 1, sr, l, r);

    }

    static int createSegment(int st[], int si, int arr[], int l, int r) {
        if (l == r) {
            st[si] = arr[l];
            return st[si];
        }
        int mid = l + (r - l) / 2;

        st[si] = createSegment(st, si * 2 + 1, arr, l, mid) + createSegment(st, si * 2 + 2, arr, mid + 1, r);

        return st[si];
    }

    public static void main(String[] args) {

        int arr[] = new int[] { 1, 2, 5, 6, 7, 9 };
        int n = arr.length;
        int st[] = new int[20];

        createSegment(st, 0, arr, 0, n - 1);
        System.out.println("before update");
        for (int i = 0; i < st.length; i++) {
            System.out.print(st[i]+ "  ");
        }
        // update
        System.out.println(" sum : " + getSum(st, 0, 0, n - 1, 2, 5));
        int update_value = 10;
        int index = 2;
        int diff = update_value - arr[index];
        System.out.println("after update");
        update(st, 0, 0, n - 1, index, diff);
        for (int i = 0; i < st.length; i++) {
            System.out.print(st[i]+ "  " );
        }

    }
}


//                             0-5(30)35
//                     0-2(8)13               3-5(22)
//             
//          0-1(3)            2-2(5)         3-4(13)       5-5(9)
//            
//   0-0(1)         1-1(2)     d      d    3-3(6)    3-3(7)        