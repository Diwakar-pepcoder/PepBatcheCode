import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int v[] = new int[n];
        for(int i=0;i<n;i++)v[i] = scn.nextInt();
        
        int w[] = new int[n];
        for(int i=0;i<n;i++)w[i] = scn.nextInt();
        
        int cap = scn.nextInt();
        
        // code
        int qb[] = new int[cap+1];
        
        for(int i=0;i<n;i++){
            int value = v[i];
            int weight = w[i];
            
            for(int c=weight;c<=cap;c++){
                
                int inc = value + qb[c-weight];
                
                if(inc > qb[c]){
                    qb[c] = inc;
                }
            }
        }
        
        System.out.println(qb[cap]);
    }
}