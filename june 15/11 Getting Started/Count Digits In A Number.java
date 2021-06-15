import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int count = 0;
        
        while( n > 0){
            int q = n/10;
            int r = n%10;
            // count = count+1;
            count++;
            n = q;
        }
        
        System.out.println(count);
   }
  }