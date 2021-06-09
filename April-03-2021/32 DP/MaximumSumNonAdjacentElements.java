import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        
        int inc[] = new int[n];
        int exc[] = new int[n];
        
        inc[0] = arr[0];
        
        for(int i=1;i<n;i++){
            inc[i] = exc[i-1] + arr[i];
            exc[i] = Math.max(inc[i-1], exc[i-1]);
        }
        
        System.out.println(Math.max(inc[n-1], exc[n-1]));
    }
}