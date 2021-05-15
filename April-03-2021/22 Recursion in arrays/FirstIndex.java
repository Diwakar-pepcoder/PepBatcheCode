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
        int x = scn.nextInt();
        int max = firstIndex(ar, 0, x);
        System.out.println(max);
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }
        
        if(arr[idx] == x){
            return idx;
        }
        
        return firstIndex(arr, idx+1, x);
    }

}