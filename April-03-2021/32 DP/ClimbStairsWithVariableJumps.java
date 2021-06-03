import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int jumpLimit[] = new int[n];
        for(int i=0;i<n;i++){
            jumpLimit[i] = scn.nextInt();
        }
        
        // storage
        int qb[] = new int[n+1];
        qb[n] = 1;
        for(int i=n-1;i>=0;i--){
            
            int totalways = 0;
            for(int jump=1;jump<=jumpLimit[i] && i+jump <= n ; jump++){
                totalways += qb[i+jump];
            }
            qb[i] = totalways;
        }
        
        System.out.println(qb[0]);
    }

}