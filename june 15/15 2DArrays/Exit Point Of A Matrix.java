import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn  = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int i=0;
        int j=0;
        int dir = 0;
        
        while( true ){
            if(arr[i][j] == 1){
                dir++;
                if(dir==4)dir=0;
            }
            
            if(dir == 0){
                if(j == m-1)break;
                j++;
            }else if(dir == 1){
                if(i == n-1)break;
                i++;
            }else if(dir == 2){
                if(j-1 < 0)break;
                j--;
            }else if(dir == 3){
                if(i-1 < 0)break;
                i--;
            }
        }
        System.out.println(i);
        System.out.println(j);
        
    }

}