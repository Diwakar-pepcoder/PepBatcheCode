import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int left = n*m;
        int rmin = 0;
        int cmin = 0;
        int rmax = n-1;
        int cmax = m-1;
        
        while(left > 0){
            
            for(int r=rmin;r<=rmax;r++){
                System.out.println(arr[r][cmin]);
                left--;
            }
            for(int c=cmin+1;c<=cmax;c++){
                System.out.println(arr[rmax][c]);
                left--;
            }
            if(left == 0){
                break;
            }
            for(int r=rmax-1;r>=rmin;r--){
                System.out.println(arr[r][cmax]);
                left--;
            }
            for(int c=cmax-1;c>=cmin+1;c--){
                System.out.println(arr[rmin][c]);
                left--;
            }
            
            rmin++;cmin++;
            rmax--;cmax--;
        }
        
    }

}