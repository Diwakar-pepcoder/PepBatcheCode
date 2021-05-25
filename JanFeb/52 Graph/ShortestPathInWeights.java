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
      
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      boolean visited[] = new boolean[vtces];
      pq.add(new Pair(src, src+"", 0));
      
      while(pq.size() > 0){
            Pair p = pq.remove();
            if(visited[p.v]){
                continue;
            }
            visited[p.v] = true;
            
            System.out.println(p.v+" via "+p.path+" @ "+p.wt);
            
            for(Edge e: graph[p.v]){
                if(visited[e.nbr] == false){
                    pq.add(new Pair(e.nbr, p.path+e.nbr, p.wt+e.wt));
                }
            }
      }
      
   }
   
   public static class Pair implements Comparable<Pair> {
       int v;
       String path;
       int wt;
       Pair(int v, String p, int w){
           this.v = v;
           path = p;
           wt = w;
       }
       // a < b -v,  a == b 0, a>b +v
       public int compareTo(Pair b){
           // a = this
           // b
           if(this.wt < b.wt)return -1;
           if(this.wt > b.wt)return 1;
           return 0;
       }
   }
   
}

















