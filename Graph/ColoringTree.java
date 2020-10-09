import java.util.*;

class ColoringTree {

    static HashSet<Integer> terminal = new HashSet();
    static boolean visited[];

    static void traverse(int t, HashSet<Integer> crowd, HashSet<Integer> temp_crowd, Set<Integer> adj[]) {
        Iterator i = adj[t].iterator();
        visited[t] = true;
        // System.out.println(" node = "+t+" temp_crowd_size = "+temp_crowd.size());
        if (terminal.contains(t) && temp_crowd.size() > 0) {
            // System.out.println("Inside crowd to add");
            Iterator it = temp_crowd.iterator();
            while (it.hasNext()) {
                crowd.add((int) it.next());

            }
            temp_crowd.clear();

        }

        while (i.hasNext()) {
            int u = (int) i.next();
            if (visited[u] == false) {
                temp_crowd.add(u);
                traverse(u, crowd, temp_crowd, adj);
                if (temp_crowd.contains(u))
                    temp_crowd.remove(u);
            }

        }

    }

    static void solution(Set<Integer> adj[]) {
        Iterator i = terminal.iterator();
        HashSet<Integer> crowd = new HashSet();
        HashSet<Integer> temp_crowd = new HashSet();

        while (i.hasNext()) {
            int t = (int) i.next();
            crowd.add(t);
            // System.out.println(" Call node : "+t);
            traverse(t, crowd, temp_crowd, adj);

        }
        // System.out.println("answer is : ");

        System.out.println(crowd.size());

    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        visited = new boolean[n];
        Set<Integer> adj[] = new Set[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 0; i < k; i++) {
            int t = sc.nextInt() - 1;
            terminal.add(t);
        }

        solution(adj);
        // for(int i=0;i<n;i++){
        // System.out.println(adj[i]);
        // }

    }
}
