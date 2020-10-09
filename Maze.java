
// Teleportation
public class Maze  {
 
    static int x[] = new int[] { 1, 0, -1, 0 };
    static int y[] = new int[] { 0, 1, 0, -1 };

    static boolean isValid(int r1, int c1, int row, int col) {
        if (r1 >= 0 && r1 < row && c1 >= 0 && c1 < col)
            return true;
        return false;
    }

    static void dfs(int[][] r, String[] a, int r1, int c1, int m) {
        // if (isValid(r1, c1, r.length, r[0].length))
        //     return;
         
        if (r[r1][c1] > m)
            return;
        if (r[r1][c1] != -1)
            return;
        r[r1][c1] = m;
        for (int i = 0; i < x.length; i++) {
            int xs = x[i] + r1;
            int ys = y[i] + c1;
            if (isValid(xs, ys, r.length, r[0].length)) {
                if (a[xs].charAt(ys) == '.')//mistake can be here
                    dfs(r, a, xs, ys, m + 1);
                else {
                    do {
                        if (a[xs].charAt(ys) == '.') {
                            dfs(r, a, xs, ys, m + 2);
                            break;
                        }
                        xs += x[i];
                        ys += y[i];

                    } while(isValid(xs, ys, r.length, r[0].length));

                }

            }

        }
    }

    public static int pathLength(String[] a, int r1, int c1, int r2, int c2) {
        int r[][] = new int[a.length][a[0].length()];
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                r[i][j] = -1;
            }
        }

        dfs(r, a, r1, c1, 0);

        return r[r2][c2];
    }
    
    public static void main(String[] args) {
       // Scanner sc=new Scanner(System.in);
        System.out.println();//take the string as input and check itself.

        // for (int i = 0; i < r.length; i++) {
        //     for (int j = 0; j < r[i].length; j++) {
        //         System.out.print(r[i][j]+"  ");
        //     }
        //     System.out.println(" ");
        // }
    }
}
