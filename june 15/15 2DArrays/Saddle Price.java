import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        for(int i=0;i<n;i++){
            int rmc = 0;
            for(int c=0;c<n;c++){
                if(arr[i][c] < arr[i][rmc]){
                    rmc = c;
                }
            }
            
            int flag = 1;
            for(int r=0;r<n;r++){
                if(arr[r][rmc] > arr[i][rmc]){
                    flag = 0;
                    break;
                }
            }
            
            if(flag == 1){
                System.out.println(arr[i][rmc]);
                return;
            }
        }
        
        System.out.println("Invalid input");
    }

}