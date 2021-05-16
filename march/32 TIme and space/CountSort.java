import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
        int size = max-min + 1;
        int freq[] = new int[size];
        
        for(int e: arr){
            int ind = e - min;
            freq[ind]++;
        }
        
        for(int i=1; i<size;i++){
            freq[i] += freq[i-1];
        }
        
        int ans[] = new int[arr.length];
        
        for(int j=arr.length-1; j>=0; j--){
            int ind = arr[j] - min;
            int aind = freq[ind]-1;
            ans[aind] = arr[j];
            freq[ind]--;
        }
        
        // ans -> arr
        for(int i=0;i<arr.length;i++){
            arr[i] = ans[i];
        }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}