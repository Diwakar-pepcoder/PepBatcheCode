import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int cost[] = new int[n];
        for(int i=0;i<n;i++){
            cost[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        
        int buy[] = new int[k+1];
        int sel[] = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        
        for(int i=0;i<n;i++){
            int price = cost[i];
            
            for(int c=1;c<=k;c++){
                buy[c] = Math.max(buy[c], sel[c-1]-price);
                sel[c] = Math.max(sel[c], buy[c]+price);
            }
        }
        int max = 0;
        for(int val:sel){
            max = Math.max(max, val);
        }
        System.out.println(max);
    }

}