import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int a=0;
        int b=1;
        while( n > 0){
            // code
            System.out.println(a);
            int c = a+b;
            a=b;
            b=c;
            
            n = n-1;
        }
        
   }
  }