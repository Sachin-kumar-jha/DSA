package Graph.Question;

import java.util.ArrayList;

public class AllpathfromSrcToDest {
       static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
this.src=src;
this.dest=dest;
        }
    }

public static void printAllPath(ArrayList<Edge>graph[],int src,int dest,String path){
if (src==dest) {
    System.out.println(path+dest);  
    return;     
}
for(int i=0;i<graph[src].size();i++){
    System.out.println("src:"+" "+src+" "+"dest:"+" "+dest);
    Edge e=graph[src].get(i);
    System.out.println("src:"+" "+e.src+" "+"dest:"+" "+e.dest);
    printAllPath(graph, e.dest, dest, path+src);
}

    }

 public static void main(String[] args) {
        int V=6;
        
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
 
        
    //    graph[0].add(new Edge(0,2));
    //    graph[0].add(new Edge(0, 2));

       graph[0].add(new Edge(0, 3));
       graph[2].add(new Edge(2,3));
       graph[3].add(new Edge(3, 1));


        graph[4].add(new Edge(4, 0));
       graph[4].add(new Edge(4, 1));

       graph[5].add(new Edge(5, 0));
       graph[5].add(new Edge(5, 2));
      // graph[3].add(new Edge(3,0 ));
    
      int src=5,dest=1;
    printAllPath(graph, src, dest, "");
    //Here this code taking exponential time for worst case scenario
    }
}
