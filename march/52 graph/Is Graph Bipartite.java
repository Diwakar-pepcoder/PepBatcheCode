import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int visited[] = new int[vtces];
      
      boolean bipar = true;
      for(int i=0;i<vtces;i++){
          if(visited[i] == 0){
              boolean result = hasCycle(graph, i, visited);
              if(!result){
                  bipar = false;
                  break;
              }
          }
      }
      System.out.println(bipar);
   }
   
   public static boolean hasCycle(ArrayList<Edge>[] graph, int src, int visited[]){
       Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, 1));
      while(q.size() >0){
            Pair e = q.remove();
            
            if(visited[e.ver] != 0){
                int curr = visited[e.ver]%2;
                int tobe = e.gr%2;
                if(curr == tobe){
                    continue;
                }else{
                    return false;
                }
            }
            visited[e.ver] = e.gr;
            
            for(Edge edge: graph[e.ver]){
                if(visited[edge.nbr] == 0){
                    q.add(new Pair(edge.nbr, e.gr+1));
                }
            }
      }
      return true;
   }
   
   public static class Pair{
       int ver;
       int gr;
       Pair(int v, int g){
           ver = v;
           gr = g;
       }
   }
   
}
