package Graph.Question;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }


    public static void main(String[] args) {
        int V = 5;

        // ArrayList<Edge>[] graph = new ArrayList[V];
        // for (int i = 0; i < V; i++) {
        //     graph[i] = new ArrayList<>();
        // }

        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 2, -4));
       
        // graph[2].add(new Edge(2, 3, 2));
        // graph[3].add(new Edge(3, 4, 4));

        // graph[4].add(new Edge(4, 1, -1));

        List<Edge>graph=new ArrayList<>();
         graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
        int src=0;
        //bellmanFord1(graph, src);
        bellmanFord2(graph, src, V);
    }

    public static void bellmanFord1(ArrayList<Edge>graph[],int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int V=graph.length;

        for(int i=0;i<V-1;i++){
         //edges-O(E)
         for(int j=0;j<graph.length;j++){
            for(int k=0;k<graph[j].size();k++){
                Edge e=graph[j].get(k);
                //u,v,wt
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
         }
        }
for(int i:dist){
    System.out.print(i+" ");
}


    }

public static void bellmanFord2(List<Edge>graph,int src,int V){
        int dist[]=new int[V];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<V-1;i++){
         //edges-O(E)
         for(int j=0;j<graph.size();j++){
                Edge e=graph.get(j);
                //u,v,wt
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
         }
        }
for(int i:dist){
    System.out.print(i+" ");
}


    }


}
