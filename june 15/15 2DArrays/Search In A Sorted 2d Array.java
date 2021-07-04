import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn  = new Scanner(System.in);

        int n = scn.nextInt();
    
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        
        int d = scn.nextInt();
        
        int i = 0;
        int j = n-1;
        
        while(i!=n && j!=-1){
            if(arr[i][j] < d){
                i++;
            }else if(arr[i][j] > d){
                j--;
            }else{
                System.out.println(i);
                System.out.println(j);
                break;
            }
        }
        
        if(i==n || j== -1){
            System.out.println("Not Found");
        }
    }

}