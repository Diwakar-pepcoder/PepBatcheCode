import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = scn.nextInt();
        }
        int max = maxOfArray(ar, 0);
        System.out.println(max);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        
        int faithmax = maxOfArray(arr, idx+1);
        
        if(arr[idx] > faithmax){
            return arr[idx];
        }else{
            return faithmax;
        }
    }

}