import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)ar[i] = scn.nextInt();
        printTargetSumSubsets(ar, 0, "", scn.nextInt());
    }

    // set is the subset
    // sos is sum of subset`
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int tar) {
        if(idx == arr.length){
            if(tar == 0)
                System.out.println(set+".");
            return;
        }
        
        // include
        if(arr[idx] <= tar)
            printTargetSumSubsets(arr, idx+1, set+arr[idx]+", ", tar-arr[idx]);
        // exclude
        printTargetSumSubsets(arr, idx+1, set, tar);
        
        
    }

}