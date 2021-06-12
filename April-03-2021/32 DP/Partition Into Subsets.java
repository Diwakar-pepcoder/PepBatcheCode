import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k) {
        long qb[][] = new long[n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(i==j){
                    qb[i][j] = 1;
                    continue;
                }
                if(j>i){
                    qb[i][j] = 0;
                    continue;
                }
                if(j==0){
                    qb[i][j] = 0;
                    continue;
                }
                qb[i][j] = qb[i-1][j-1] + j*qb[i-1][j];
            }
        }
        return qb[n][k];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}