import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        //  int arr[];// declaration
        //  arr = new int[5];// initialization
        
        int arr1[] = new int[5];
        arr1[0] = 9;
        arr1[1] = 14;
        arr1[2] = 56;
        arr1[3] = arr1[0]+arr1[1];
        
        int len = arr1.length;
        
        for(int i=0;i<len;i++){
           System.out.println(arr1[i]); 
        }
    }
    
    public static void swap(int ar[]){
        ar[0] = -6;
        ar[1] = -5;
    }
    
}
