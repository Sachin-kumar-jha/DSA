package Graph.Impletation;

import java.util.ArrayList;

public class GraphCreation {
    public static class Edge{
        private int src;
        private int dest;
        private int weight;

        public Edge(int src,int dest,int weight){
        this.src=src;
       this.dest=dest;
        this.weight=weight;
        }
    };




    public static void main(String[] args) {
        int V=5;
        
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
 
        graph[0].add(new Edge(0,1, 2));
        graph[0].add(new Edge(0, 2, 3));
        graph[1].add(new Edge(1, 2, 3));
        graph[1].add(new Edge(1, 3, 4));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 4, 3));
        graph[4].add(new Edge(4, 5, 3));


        for(int i=0;i<graph[0].size();i++){
            Edge e=graph[0].get(i);
            System.out.println(e.src);
            System.out.println(e.dest);
            System.out.println(e.weight);
        }

    }
    
}
