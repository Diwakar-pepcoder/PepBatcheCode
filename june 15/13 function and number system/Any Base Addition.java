import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
        
        int ans=0;
        int multi = 1;// 10 ^ 0
        int carry=0;
        while( n1>0 || n2 >0 || carry > 0 ){
            int q1 = n1/10;
            int r1 = n1%10;
            int q2 = n2/10;
            int r2 = n2%10;
            
            int sum = r1+r2+carry;
            
            carry = sum/b;
            int digit = sum%b;
            // ans
            
            ans += digit*multi;
            
            multi *= 10;
            n1 = q1;
            n2 = q2;
        }
        return ans;
   }
  }