import java.io.*;
import java.util.*;

public class Main{
    
    public static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int s,int n, int w){
            src = s;
            nbr = n;
            wt = w;
        }
    }
    
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        
        int vtces = scn.nextInt();
        
        ArrayList<Edge> graph[] = new ArrayList[vtces];
        
        for(int i=0;i<vtces;i++){
            graph[i] = new ArrayList<>();
        }
        
        int ecount = scn.nextInt();
        
        for(int i=0;i<ecount;i++){
            int s = scn.nextInt();
            int n = scn.nextInt();
            int w = scn.nextInt();
            
            graph[s].add(new Edge(s,n,w));
            graph[n].add(new Edge(n, s, w));
        }
        
        int src = scn.nextInt();
        int des = scn.nextInt();
        
        boolean visited[] = new boolean[vtces];
        
        boolean haspath = hasPath(graph, src, des, visited);
        System.out.println(haspath);
    }
    
    static boolean hasPath(ArrayList<Edge>[]graph, int src, int des, boolean[]visited){
        if(src == des)return true;
        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == true)continue;
            boolean exist = hasPath(graph, edge.nbr, des, visited);
            if(exist){
                return true;
            }
        }
        return false;
    }
    
}
