import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
        
        int ans = 0;
        int multi = 1;// b^0
        
        while(n!=0){
            int q = n/10;
            int r = n%10;
            
            int fac = r*multi;
            ans = ans + fac;
            
            multi *= b;
            n=q;
        }
        
        return ans;
   }
  }