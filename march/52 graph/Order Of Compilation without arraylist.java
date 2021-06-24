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
      }

      // write your code here
      Stack<Integer> st = new Stack<>();
      boolean visited[] = new boolean[vtces];
      for(int i=0;i<vtces;i++){
            if(visited[i] == false){
                // ArrayList<Integer> al = new ArrayList<>();
                dfs(graph, i, st, visited);
                // for(int j=al.size() -1;j>=0;j--){
                //     st.push(al.get(j));
                // }
            }
      }
        while(st.size() > 0){
            System.out.println(st.pop());
        }
   }
   
   public static void dfs(ArrayList<Edge>[] graph, int src, Stack<Integer> st, boolean visited[]){
        visited[src] = true;
        // al.add(src);
        for(Edge edge: graph[src]){
            if(visited[edge.nbr] == false){
                dfs(graph, edge.nbr, st, visited);
            }
        }
        st.push(src);
   }
   
}