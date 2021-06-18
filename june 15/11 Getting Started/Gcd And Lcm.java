import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
        
            int n1 = scn.nextInt();
            int n2 = scn.nextInt();
            
            int a = n1;
            int b = n2;
            
            while(a!=0){
                int r = b%a;
                b=a;
                a=r;
            }
            
            System.out.println(b);
            int lcm = n1*n2/b;
            System.out.println(lcm);
            
     }
    }