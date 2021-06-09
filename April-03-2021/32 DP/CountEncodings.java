import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String s = scn.nextLine();
        
        int n = s.length();
        //
        
        int qb[] = new int[n];
        qb[0] = 1;
        
        for(int i=1;i<n;i++){
            
            int single = s.charAt(i) -'0';
            if(single >= 1 && single <= 9){
                qb[i] += qb[i-1];
            }
            
            int pair = Integer.parseInt(s.substring(i-1, i+1));
            if(pair>=10 && pair<=26){
                int ind = i-2;
                if(ind == -1){
                    qb[i] += 1;
                }else{
                    qb[i] += qb[ind];
                }
            }
        }
        
        System.out.println(qb[n-1]);
    }
}