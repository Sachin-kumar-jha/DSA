package Graph.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CycleDetectionInDirectedGraph {
    public static class Edge{
        private int src;
        private int dest;
      

        public Edge(int src,int dest){
        this.src=src;
       this.dest=dest;
      
        }
    };

public static boolean isCycle(List<Edge>[]graph){
    boolean vis[]=new boolean[graph.length];
    boolean stack []=new boolean[graph.length];

    for(int i=0;i<graph.length;i++){
        if (!vis[i]) {
          if(isCycleUtil(graph,i,vis,stack)) {
            return true;
          } ;
        }
    }
    return false;
}

public static boolean isCycleUtil(List<Edge>graph[],int curr,boolean[]vis,boolean stack[]){
      vis[curr]=true;
      stack[curr]=true;

      for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(stack[e.dest]){
            return true;
        }
        if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
            return true;
        }
      }

      stack[curr]=false;
      return false;
}

public static void TopologicalSorting(List<Edge>graph[]){
     boolean vis[]=new boolean[graph.length];
     Stack<Integer>stack=new Stack<>();

    for(int i=0;i<graph.length;i++){
        if (!vis[i]) {
          topSortUtil(graph,i,vis,stack);   //DFS FUnction
          } ;
}

   while (!stack.isEmpty()) {
            System.out.println(stack.pop()+" ");
          }
}
    

public static void topSortUtil(List<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
    vis[curr]=true;
    for(int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);
        if (!vis[e.dest] ) {
            topSortUtil(graph,e.dest, vis, stack);
        }
    }
stack.push(curr);
    
}

    public static void main(String[] args) {
        int V=6;
        
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
 
        
    //    graph[0].add(new Edge(0,2));
    //    graph[0].add(new Edge(0, 2));

       graph[2].add(new Edge(2,3));
       graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
       graph[4].add(new Edge(4, 1));

       graph[5].add(new Edge(5, 0));
       graph[5].add(new Edge(5, 2));
      // graph[3].add(new Edge(3,0 ));

      TopologicalSorting(graph);
    }
    


}
