package Graph.Question;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijKastras {

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
        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 5, 5));

        int src=0;
        dijkstra(graph, src);
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

    Pair(int n,int path){
        this.n=n;
        this.path=path;
    }

    @Override
    public int compareTo(Pair p2) {
      return this.path-p2.path; //Path based sorting for pairs
    }
    }

    public static void dijkstra(ArrayList<Edge>graph[],int src){
       int dist[]=new int[graph.length]; //dist[i]--> src to i
       boolean vis[]=new boolean[graph.length];
     for(int i=0;i<graph.length;i++){
        if(i!=src){
            dist[i]=Integer.MAX_VALUE; //+Infinity
        }
     }
     
     PriorityQueue<Pair>pq=new PriorityQueue<>();
     pq.add(new Pair(src,0));

     while (!pq.isEmpty()) {
        Pair curr=pq.remove();

        if(!vis[curr.n]){
            vis[curr.n]=true;
            //neighbours
            for(int i=0;i<graph[curr.n].size();i++){
                Edge e = graph[curr.n].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;

                if (dist[u]+wt<dist[v]) { //update dist
                    dist[v]=dist[u]+wt;
                    pq.add(new Pair(v, dist[v]) );
                }
            }
        }

     }   
     for(int i:dist){
        System.out.print(i+" ");
     }
    }
}
