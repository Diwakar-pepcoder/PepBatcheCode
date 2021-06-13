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
        
        int buy1 = -cost[0];
        int buy2 = -cost[0];
        int sell1=0, sell2=0;
        
        for(int i=1;i<n;i++){
            int price = cost[i];
            
            buy1 = Math.max(buy1, 0-price);
            sell1 = Math.max(sell1, buy1+price);
            
            buy2 = Math.max(buy2, sell1-price);
            sell2 = Math.max(sell2, buy2+price);
        }
        
        System.out.println(sell2);
    }

}