package Graph.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
      static class Edge {
        private int src;
        private int dest;

       public Edge(int s,int d){
        this.src=s;
        this.dest=d;
       }
    };

     public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }


        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { // BFS
                q.add(i);
                color[i] = 0; // let 0 means Yellow Color
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // e.dest
                        // Case 1:Current edge not coloured
                        if (color[e.dest] == -1) {
                            int newcolor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = newcolor;
                            q.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    public static boolean isBipartite2(ArrayList<Edge>[] graph) {
    int color[] = new int[graph.length];
    int level[] = new int[graph.length]; // BFS level for cycle length check
    for (int i = 0; i < color.length; i++) {
        color[i] = -1;
        level[i] = -1;
    }

    if(detectCycle(graph)) {
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < graph.length; i++) {
        if (color[i] == -1) { // BFS for each component
            q.add(i);
            color[i] = 0;
            level[i] = 0;

            while (!q.isEmpty()) {
                int curr = q.remove();
                for (int j = 0; j < graph[curr].size(); j++) {
                    Edge e = graph[curr].get(j);

                    if (color[e.dest] == -1) {
                        color[e.dest] = 1 - color[curr];
                        level[e.dest] = level[curr] + 1;
                        q.add(e.dest);
                    } else if (color[e.dest] == color[curr]) {
                        // found a cycle
                        int cycleLength = level[curr] + level[e.dest] + 1;
                        if (cycleLength % 2 == 1) {
                            System.out.println("Odd cycle of length " + cycleLength);
                            return false; // odd → not bipartite
                        } else {
                            System.out.println("Even cycle of length " + cycleLength);
                        }
                    }
                }
            }
        }
    }
    return true;
}else return false;
   
     // graph is bipartite (only even cycles / no cycles)
}



   public static boolean detectCycle(ArrayList<Edge>[]graph){
    boolean vis[]=new boolean[graph.length];
    for(int i=0;i<graph.length;i++){
        if (!vis[i]) {
          if(detectCycleUtil(graph,vis,i,-1)){
   return true;
          }
           }
        }
    
    return false;
}

private static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean vis[],int curr,int parent) {
     vis[curr]=true;
     for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);

        //Case 3:
        if(!vis[e.dest]){
       if (detectCycleUtil(graph,vis,e.dest,curr)) {
            return true;
        } 
        }
        //Case 1:
        else if (vis[e.dest] && e.dest!= parent ){
      return true; 
        }
     }
     return false;
} 
    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
       graph[3].add(new Edge(3, 4));

       graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));

        System.out.println(isBipartite2(graph));

    }

   

}
