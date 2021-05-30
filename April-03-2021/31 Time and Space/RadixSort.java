import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
        int max=0;
        for(int val: arr){
            max = Math.max(max, val);
        }
        int exp = 1;
        while(max/exp > 0){
            countSort(arr, exp);
            exp *= 10;
        }
  }

  public static void countSort(int[] arr, int exp) {
        int size = 10;
        int count[] = new int[size];
        
        for(int val: arr){
            int digit = (val/exp)%10;
            int ind = digit;
            count[ind]++;
        }
        
        for(int i=1; i<size;i++){
            count[i] = count[i] + count[i-1];
        }
        
        int ans[] = new int[arr.length];
        
        for(int i=arr.length-1;i>=0;i--){
            int val = arr[i];
            
            int ind = (val/exp)%10;
            int ps = count[ind];
            
            ans[ps-1] = val;
            count[ind]--;
        }
        
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