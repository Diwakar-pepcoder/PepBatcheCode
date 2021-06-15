import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       
       int t = scn.nextInt();
       
       while( t > 0){
           int n = scn.nextInt();
           // code to check if n is prime
           
           int div = 2;
           int count =0 ;
           
           while(div*div <= n){
               if(n%div == 0){
                   count = count+1;
               }
               div = div+1;
           }
           if(count == 0){
               System.out.println("prime");
           }else{
               System.out.println("not prime");
           }
           
           t = t-1;
       }
  
   }
  }