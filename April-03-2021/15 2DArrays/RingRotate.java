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
        
        int s = scn.nextInt();
        int r = scn.nextInt();
        
        shellRotate(arr, r, s);
        display(arr);
    }
    
    public static void shellRotate(int arr[][], int r, int s){
        int oD[] = twodto1d(arr, s);
        rotate(oD, r);
        oD2twoD(arr, oD, s);
    }
    
    public static void rotate(int[] a, int k){
        int n = a.length;
        k = k%n;
        if(k<0){
            k = k+n;
        }
        reverse(a, 0, n-k-1);
        reverse(a, n-k, n-1);
        reverse(a, 0, n-1);
    }

    public static void reverse(int[] a, int i, int j){
        while(i<j){
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }
    public static int[] twodto1d(int arr[][], int s){
        int rmin = s-1, rmax=arr.length-s, cmin=s-1, cmax=arr[0].length-s;
        int size = 2*(rmax+cmax -rmin - cmin);
        int oD[] = new int[size];
        int i=0;
        for(int r=rmin;r<=rmax;r++){
            oD[i] = arr[r][cmin];
            i++;
        }
        for(int c=cmin+1;c<=cmax;c++){
            oD[i] = arr[rmax][c];
            i++;
        }
        for(int r = rmax-1; r>=rmin; r--){
            oD[i] = arr[r][cmax];
            i++;
        }
        for(int c = cmax-1;c>=cmin+1;c--){
            oD[i] = arr[rmin][c];
            i++;
        }
        return oD;
    }
    
    public static void oD2twoD(int arr[][], int oD[], int s){
        int rmin = s-1, rmax=arr.length-s, cmin=s-1, cmax=arr[0].length-s;

        int i=0;
        
        for(int r=rmin;r<=rmax;r++){
            arr[r][cmin] = oD[i];
            i++;
        }
        for(int c=cmin+1;c<=cmax;c++){
            arr[rmax][c] = oD[i];
            i++;
        }
        for(int r = rmax-1; r>=rmin; r--){
            arr[r][cmax] = oD[i];
            i++;
        }
        for(int c = cmax-1;c>=cmin+1;c--){
            arr[rmin][c] = oD[i];
            i++;
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}