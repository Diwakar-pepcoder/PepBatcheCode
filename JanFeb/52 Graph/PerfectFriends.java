import java.io.*;
import java.util.*;

public class Main {

  static class Edge {
    int src;
    int nbr;
    Edge(int s, int n) {
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
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < k; i++) {
      String s = br.readLine();// 0 1
      String ve[] = s.split(" ");// ["0", "1"]

      int src = Integer.parseInt(ve[0]);// src "0"
      int nbr = Integer.parseInt(ve[1]);// nbr "1"

      graph[src].add(new Edge(src, nbr));
      graph[nbr].add(new Edge(nbr, src));
    }

    ArrayList<Integer> comps = new ArrayList<>();

    boolean visited[] = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (visited[i] == false) {
        ArrayList<Integer> comp = new ArrayList<Integer>();
        gcc(graph, i, visited, comp);
        comps.add(comp.size());
      }
    }

    int ans=0;
    
    for(int i=0;i<comps.size();i++){
        for(int j=i+1;j<comps.size();j++){
            ans += comps.get(i) * comps.get(j);
        }
    }
    
    System.out.println(ans);

  }

  public static void gcc( ArrayList<Edge>[] graph, int src, boolean visited[], ArrayList<Integer> comp) {

    visited[src] = true;
    comp.add(src);
    for (Edge e : graph[src]) {
      if (visited[e.nbr] == false) {
        gcc(graph, e.nbr, visited, comp);
      }
    }
  }
}












