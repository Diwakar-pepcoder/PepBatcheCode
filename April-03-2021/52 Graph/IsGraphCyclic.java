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

      boolean visited[] = new boolean[vtces];
      boolean hascycle = false;
      for(int i=0;i<vtces;i++){
          if(visited[i] == false){
              boolean ans = hasCycle(graph, i, visited);
              if(ans){
                  hascycle = true;
                  break;
              }
          }
      }
      
      System.out.println(hascycle);
   }
   
   static boolean hasCycle(ArrayList<Edge>graph[], int src, boolean visited[]){
       ArrayDeque<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, src+""));
      
      while(q.size() > 0){
            // r m p an
            Pair p = q.remove();
            if(visited[p.src] == true){
                return true;
            }else{
                visited[p.src] = true;
            }
            // System.out.println(p.src+"@"+p.path);
            
            for(Edge e: graph[p.src]){
                if(visited[e.nbr] == false){
                    q.add(new Pair(e.nbr, p.path+e.nbr));
                }
            }
      }
      return false;
   }
   
   static class Pair{
       int src;
       String path;
       Pair(int s, String p){
           src = s;
           path = p;
       }
   }
}






