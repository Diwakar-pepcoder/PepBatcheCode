import java.util.*;

public class Main{

public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int index=0;
        int inv=0;
        
        while(n != 0){
            int q = n/10;
            int r = n%10;
            index++;
            
            int invd = index;
            int invi = r;
            inv = inv+invd*((int)Math.pow(10, invi-1));
            n=q;
        }
        
        System.out.println(inv);
 }
}