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
        
        //
        int buy = cost[0];
        int sell = cost[0];
        int profit = 0;
        
        for(int i=1;i<n;i++){
            if(cost[i-1] < cost[i]){// increasing
                sell = cost[i];
            }else{
                profit += sell-buy;
                sell = buy = cost[i];
            }
        }
        profit += sell-buy;
        System.out.println(profit);
    }

}