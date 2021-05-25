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

        int group[] = new int[vtces];
        
        boolean bipar = true;
        for(int i=0;i<vtces;i++){
            if(group[i] == 0){
                boolean possible = assignGroup(i, graph, group);
                if(possible == false){
                    bipar = false;
                    break;
                }
            }
        }
        System.out.println(bipar);
   }
   public static boolean assignGroup(int src, ArrayList<Edge>[] graph, int group[]){
       
       Queue<Pair> q = new LinkedList<>();
       
       q.add(new Pair(src, 1));
       
       while(q.size() > 0){
           Pair p = q.remove();
           if(group[p.v] != 0){
               if(group[p.v] != p.g){
                   return false;
               }
               continue;
           }else{
               group[p.v] = p.g;
           }
           for(Edge e: graph[p.v]){
               q.add(new Pair(e.nbr, p.g*-1));
           }
       }
       
       return true;
   }
   public static class Pair{
       int v;
       int g;
       Pair(int v, int g){
           this.v = v;
           this.g = g;
       }
   }
   
}
