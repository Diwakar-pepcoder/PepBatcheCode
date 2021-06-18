import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        
        int aa = a*a;
        int bb = b*b;
        int cc = c*c;
        
        if(aa == bb+cc || bb == aa+cc || cc == aa+bb){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
   }
  }