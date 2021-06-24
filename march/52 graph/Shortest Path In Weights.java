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

      int src = Integer.parseInt(br.readLine());
      // write your code here
      PriorityQueue<Pair> q = new PriorityQueue<>();
      q.add(new Pair(src, ""+src, 0));
      boolean visited[] = new boolean[vtces];
      while(q.size() > 0){
            Pair p = q.remove();
            if(visited[p.src] == true)continue;
            visited[p.src]=true;
            System.out.println(p.src+" via "+p.path+" @ "+p.wt);
            for(Edge e: graph[p.src]){
                if(visited[e.nbr] == false){
                    q.add(new Pair(e.nbr, p.path+e.nbr, p.wt+e.wt));
                }
            }
      }
   }
   public static class Pair implements Comparable<Pair>{
       int src;
       String path;
       int wt;
       Pair(int s, String p, int w){
           src = s;
           path = p;
           wt = w;
       }
       
       public int compareTo(Pair b){
           if(this.wt < b.wt){
               return -1;
           }else if(this.wt == b.wt){
               return 0;
           }
           return 1;
       }
       
   }
   
}