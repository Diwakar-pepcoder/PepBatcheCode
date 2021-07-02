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
        
        int total = (int)Math.pow(2, n);
        
        for(int deci = 0; deci < total; deci++){
            int bin = decimal2Binary(deci);// 010
            
            int div = (int)Math.pow(10, n-1);
            
            for(int i=0;i<n;i++){
                int q = bin/div;
                int r = bin%div;
                
                if(q == 0){
                    System.out.print("-\t");
                }else{
                    System.out.print(arr[i]+"\t");
                }
                bin = r;
                div = div/10;
            }
            System.out.println();
        }
}
   public static int decimal2Binary(int n){
       int b=2;
       int ans=0;
       int pow=0;
       
       while( n != 0 ){
           int q = n/b;
           int r = n%b;
           
           int fac = r*(int)Math.pow(10, pow);
           ans = ans+fac;
           
           pow++;
           n=q;
       }
       
       return ans;
   }
}