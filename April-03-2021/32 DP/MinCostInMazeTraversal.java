import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int cost[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cost[i][j] = scn.nextInt();
            }
        }
        
        int qb[][] = new int[n][m];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                
                if(i==n-1 && j==m-1){
                    // destination
                    qb[i][j] = cost[i][j];
                }else if(i==n-1){
                    // horizontal call
                    qb[i][j] = cost[i][j] + qb[i][j+1];
                }else if(j==m-1){
                    // vertical
                    qb[i][j] = cost[i][j] + qb[i+1][j];
                }else{
                    // vertical horizontal
                    int min = Math.min(qb[i][j+1], qb[i+1][j]);
                    qb[i][j] = cost[i][j] + min;
                }
                
            }
        }
        System.out.println(qb[0][0]);
    }

}