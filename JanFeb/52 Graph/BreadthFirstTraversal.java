import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

        Queue<Pair> q = new ArrayDeque<>();// add remove size
        
        q.add(new Pair(src, ""+src));
        
        boolean visited[] = new boolean[vtces];
        
        while(q.size() > 0){
            Pair p = q.remove();
            if(visited[p.des] == true){
                continue;
            }else{
                visited[p.des] = true;
            }
            System.out.println(p.des+"@"+p.path);
            for(Edge e : graph[p.des]){
                if(visited[e.nbr] == false)
                q.add(new Pair(e.nbr, p.path+e.nbr));
            }
        }
   }
   
   public static class Pair{
       int des;
       String path;
       Pair(int d, String p){
           des = d;
           path = p;
       }
   }
   
}
