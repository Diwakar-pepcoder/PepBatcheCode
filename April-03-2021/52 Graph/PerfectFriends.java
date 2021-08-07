import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge{
        int src;
        int nbr;
        Edge(int s, int n){
            src = s;
            nbr = n;
        }
    }
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      // write your code here
      ArrayList<Edge> graph[] = new ArrayList[n];
      for(int i=0;i<n;i++){
          graph[i] = new ArrayList<>();
      }
      
      for(int i=1;i<=k;i++){
            String inp = br.readLine();// "0 1"
            String inps[] = inp.split(" ");// ["0", "1"]
            int src = Integer.parseInt(inps[0]);
            int nbr = Integer.parseInt(inps[1]);
            graph[src].add(new Edge(src, nbr));
            graph[nbr].add(new Edge(nbr, src));
      }
      boolean visited[] = new boolean[n];
      ArrayList<Integer>cs = new ArrayList<>();
      for(int i=0;i<n;i++){
          if(visited[i] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(graph, i, visited, comp);
                cs.add(comp.size());
          }
      }
      int ans=0;
      for(int i=0;i<cs.size();i++){
            for(int j=i+1;j<cs.size();j++){
                ans += cs.get(i) * cs.get(j);
            }
      }
      System.out.println(ans);
   }
   static void dfs(ArrayList<Edge> graph[], int src, boolean visited[], ArrayList<Integer> comp){
       visited[src] = true;
       comp.add(src);
       for(Edge edge: graph[src]){
           if(visited[edge.nbr] == false){
               dfs(graph, edge.nbr, visited, comp);
           }
       }
   }

}
