package Graph.Impletation;

import java.util.ArrayList;

public class DFS {
    static class Edge{
        int src ;
        int dest;
        int wt;
        public Edge(int s,int d ,int w){
          this.src=s;
          this.dest=d;
          this.wt=w;
        }
    }

    public static void main(String[] args) {
        
        //Vertices 
        int v =5;
         ArrayList<Edge>[]graph =new ArrayList[v];
createGraph(graph,v);
// dfs(graph,0,new boolean[v]);
System.out.println(hasPath(graph, 0, 5, new boolean[v]));
}

public static void createGraph(ArrayList<Edge>[]graph,int v){
    

  for(int i=0;i<v;i++){
    graph[i]=new ArrayList<>();
}

graph[0].add(new Edge(0, 1, 5));

graph[1].add(new Edge(1, 0, 5));
graph[1].add(new Edge(1, 2, 1));
graph[1].add(new Edge(1, 3,3 ));

graph[2].add(new Edge(2, 3, 1));
graph[2].add(new Edge(2, 1, 1));
graph[2].add(new Edge(2, 4, 2));

graph[3].add(new Edge(3 ,1, 3));
graph[3].add(new Edge(3 ,2, 1));

graph[4].add(new Edge(4 ,2, 2));
}

public static void dfs(ArrayList<Edge>[]graph,int curr,boolean vis[])
{
    System.out.println(curr+" ");
    vis[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
        Edge e =graph[curr].get(i);
        
     if (!vis[e.dest]) {
        dfs(graph, e.dest, vis);
      }
    }
   
}

public static boolean hasPath(ArrayList<Edge>[]graph,int src,int dest,boolean vis[]){
  if(src==dest){
    return true;
  }
   vis[src]=true;
  for (int i = 0; i < graph[src].size(); i++) {
    Edge e = graph[src].get(i);
    if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
      return true;
    }
  }
  return false;
}
}
