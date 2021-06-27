import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        
        int n1 = scn.nextInt();
        int ar1[] = new int[n1];
        for(int i=0;i<n1;i++){
            ar1[i] = scn.nextInt();
        }
        
        int n2 = scn.nextInt();
        int ar2[] = new int[n2];
        for(int i=0;i<n2;i++){
            ar2[i] = scn.nextInt();
        }
        int n3 = Math.max(n1,n2);
        int ans[] = new int[n3];
        int i=n1-1;
        int j=n2-1;
        int k=n3-1;
        
        int carry=0;
        while( k >= 0 ){
            
            int a=0, b=0;
            if( i >= 0){
                a = ar1[i];
            }
            if(j >= 0){
                b = ar2[j];
            }
            int sum = a+b+carry;
            carry = sum/10;
            ans[k] = sum%10;
            
            i--;
            j--;
            k--;
        }
        if(carry != 0){
            System.out.println(carry);
        }
        for(int c=0;c<n3;c++){
            System.out.println(ans[c]);
        }
        
 }

}