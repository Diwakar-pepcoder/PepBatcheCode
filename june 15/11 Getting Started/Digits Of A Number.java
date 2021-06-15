import java.util.*;
    
public class Main{
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int nod = 0;
        int copyN = n;
        while(copyN>0){
            copyN = copyN/10;
            nod++;
        }
        
        int div = (int)Math.pow(10, nod-1);
        
        while(div!=0){
            int q = n/div;
            int r = n%div;
            
            System.out.println(q);
            n=r;
            div = div/10;
        }
        
     }
    }