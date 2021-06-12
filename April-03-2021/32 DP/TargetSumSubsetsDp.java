import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int coin[] = new int[n];
        for(int i=0;i<n;i++){
            coin[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        //
        
        boolean qb[][] = new boolean[n][tar+1];
        
        for(int i=0;i<n;i++){
            for(int t=0;t<=tar;t++){
                if(t == 0 || coin[i] == t){
                    qb[i][t] = true;
                    continue;
                }
                
                boolean can = false;
                // exclude
                if(i>0){
                    can = qb[i-1][t];
                }
                // include
                if(can == false && coin[i] <= t && i>0){
                    int req = t - coin[i];
                    can = qb[i-1][req];
                }
                
                qb[i][t] = can;
            }
        }
        System.out.println(qb[n-1][tar]);
    }
}