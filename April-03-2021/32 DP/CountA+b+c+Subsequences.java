import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String s =scn.nextLine();
        int n = s.length();
        //
        int qb[][] = new int[3][n+1];
        
        for(int i=1;i<=n;i++){
            
            char ch = s.charAt(i-1);
            
            qb[0][i] = qb[0][i-1];
            qb[1][i] = qb[1][i-1];
            qb[2][i] = qb[2][i-1];
            
            
            if(ch == 'a'){
                qb[0][i] = qb[0][i-1]*2+1;
            }else if(ch == 'b'){
                qb[1][i] = qb[1][i-1]*2 + qb[0][i-1];
            }else{
                qb[2][i] = qb[2][i-1] * 2 + qb[1][i-1];
            }
        }
        
        System.out.println(qb[2][n]);
    }
}