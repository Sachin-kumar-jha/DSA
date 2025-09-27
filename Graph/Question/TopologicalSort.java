package Graph.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
this.src=src;
this.dest=dest;
        }
    
    }

public static void CalcIndex(ArrayList<Edge>[]graph, int idx[]){
    for(int i=0; i<graph.length;i++){
        for(int j=0;j<graph[i].size();j++){
            Edge e = graph[i].get(j);
            idx[e.dest]++;
        }
    }
}

public static void topSort(ArrayList<Edge>graph[]){
     int indeg[]=new int[graph.length];
     CalcIndex(graph, indeg);
     Queue<Integer> q=new LinkedList<>();

     for(int i=0;i<indeg.length;i++){
        if(indeg[i]==0){
            q.add(i);
        }
     }

     while(!q.isEmpty()){
        int curr=q.remove();

        System.out.println(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            indeg[e.dest]--;

            if (indeg[e.dest]==0) {
                q.add(e.dest);
            }
        }
     }
     System.out.println();

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
   topSort(graph);
    }
    
}