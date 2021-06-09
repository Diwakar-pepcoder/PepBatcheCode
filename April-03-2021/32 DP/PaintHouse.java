import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int cost[][] = new int[n][3];
        for(int i=0;i<n;i++){
            cost[i][0] = scn.nextInt();
            cost[i][1] = scn.nextInt();
            cost[i][2] = scn.nextInt();
        }
        
        //
        int gd[][] = new int[n][3];
        gd[0][0] = cost[0][0];
        gd[0][1] = cost[0][1];
        gd[0][2] = cost[0][2];
        
        for(int i=1;i<n;i++){
            gd[i][0] = cost[i][0] + Math.min(gd[i-1][1], gd[i-1][2]);
            gd[i][1] = cost[i][1] + Math.min(gd[i-1][0], gd[i-1][2]);
            gd[i][2] = cost[i][2] + Math.min(gd[i-1][0], gd[i-1][1]);
        }
        
        int min = gd[n-1][0];
        if(gd[n-1][1] < min)min = gd[n-1][1];
        if(gd[n-1][2] < min)min = gd[n-1][2];
        System.out.println(min);
    }
}