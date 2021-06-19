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
        hasPath(graph, src, des, visited, ""+src);

    }
    
    public static void hasPath(ArrayList<Edge> graph[], int src, int des, boolean[]visited, String path){
        if(src == des){
            System.out.println(path);
            return;
        }
        visited[src] = true;
        for(Edge edge: graph[src]){
            if(visited[edge.nbr] == false){
                hasPath(graph, edge.nbr, des, visited, path+edge.nbr);
            }
        }
        visited[src] = false;
    }
}