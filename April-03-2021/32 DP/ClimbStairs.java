import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        // int ans = climbStairR(n);
        int qb[] = new int[n+1];
        // int ans = climbStairDpM(n, qb);
        int ans = climbStairDpT(n, qb);
        
        System.out.println(ans);
    }
    
    public static int climbStairR(int n){
        if(n==0)return 1;
        int total=0;
        if(n-1 >= 0)
            total += climbStairR(n-1);
        if(n-2 >= 0)
            total += climbStairR(n-2);
        if(n-3>=0)
            total += climbStairR(n-3);
        return total;
    }
    public static int climbStairDpM(int n, int qb[]){
        if(n==0){
            qb[n] = 1;
            return 1;
        }
        if(qb[n] != 0){
            return qb[n];
        }
        
        int total=0;
        
        if(n-1 >= 0)
            total += climbStairDpM(n-1, qb);
        if(n-2 >= 0)
            total += climbStairDpM(n-2, qb);
        if(n-3>=0)
            total += climbStairDpM(n-3, qb);
        
        qb[n] = total;
        return total;
    }
    public static int climbStairDpT(int n, int qb[]){
        for(int i=0;i<=n;i++){
            if(i==0){
                qb[i] = 1;
                continue;
            }
            int total=0;
            if(i-1 >= 0)
                total += qb[i-1]; //climbStairDpM(n-1, qb);
            if(i-2 >= 0)
                total += qb[i-2]; //climbStairDpM(n-2, qb);
            if(i-3>=0)
                total += qb[i-3];//climbStairDpM(n-3, qb);
            qb[i] = total;
        }
        return qb[n];
    }

}