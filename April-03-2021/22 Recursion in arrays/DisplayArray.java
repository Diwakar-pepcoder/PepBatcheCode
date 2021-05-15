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
        
        displayArr(ar, 0);
    }

    public static void displayArr(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        
        System.out.println(arr[idx]);
        displayArr(arr, idx+1);
    }

}