import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int arr[] = new int[n];
    
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }
    
    int d = scn.nextInt();
    
    int i=0;
    int j=n-1;
    int first = -1;
    
    while(i<=j){
        int mid = (i+j)/2;
        
        if(arr[mid] < d){
            i = mid+1;
        }else if(d < arr[mid]){
            j = mid-1;
        }else{
            first = mid;
            j = mid-1;
        }
    }
    
    i=0;
    j=n-1;
    int last=-1;
    
    // TODO binary search for last index
    
    System.out.println(first);
    System.out.println(last);
    
 }
}