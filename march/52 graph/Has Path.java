import java.io.*;
import java.util.*;

public class Main {
    
    public static class Edge{
        int src;
        int nbr;
        int weight;
        Edge(int s, int n, int w){
            src = s;
            nbr = n;
            weight = w;
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        
        ArrayList<Edge> graph[] = new ArrayList[vtces];
        for(int i=0;i<vtces;i++){
            graph[i] = new ArrayList<>();
        }
        
        int edges= scn.nextInt();
        
        for(int i=0;i<edges;i++){
            int src = scn.nextInt();
            int nbr = scn.nextInt();
            int wt = scn.nextInt();
            
            graph[src].add(new Edge(src, nbr, wt));
            graph[nbr].add(new Edge(nbr, src, wt));
        }
        
        int src = scn.nextInt();
        int des = scn.nextInt();
        
        boolean visited[] = new boolean[vtces];
        boolean has = hasPath(graph, src, des, visited);
        System.out.println(has);
    }
    
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int des, boolean[]visited){
        if(src == des){
            return true;
        }
        visited[src] = true;
        for(Edge edge: graph[src]){
            if(visited[edge.nbr] == true)continue;
            boolean exist = hasPath(graph, edge.nbr, des, visited);
            if(exist){
                return true;
            }
        }
        return false;
    }
}