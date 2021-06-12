import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int qb[] = new int[n+1];
        
        qb[1] = 1;
        qb[2] = 2;
        
        for(int i=3;i<=n;i++){
            qb[i] = qb[i-1] + (i-1)*qb[i-2];
        }
        
        System.out.println(qb[n]);
    }

}