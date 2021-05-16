import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
        int max = 0;
        
        for(int e: arr)max = Math.max(max, e);
        
        int exp = 1;
        while(max/exp > 0){
            countSort(arr, exp);
            exp *= 10;
        }
  }

  public static void countSort(int[] arr, int exp) {
        int size = 10;
        int freq[] = new int[size];
        
        for(int e: arr){
            int ind = (e/exp)%10;
            freq[ind]++;
        }
        
        for(int i=1; i<size;i++){
            freq[i] += freq[i-1];
        }
        
        int ans[] = new int[arr.length];
        
        for(int j=arr.length-1; j>=0; j--){
            int ind = (arr[j]/exp)%10;
            int aind = freq[ind]-1;
            ans[aind] = arr[j];
            freq[ind]--;
        }
        
        // ans -> arr
        for(int i=0;i<arr.length;i++){
            arr[i] = ans[i];
        }
    
    
    
    
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}