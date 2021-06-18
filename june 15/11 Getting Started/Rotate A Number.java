import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int nod=0;
        int temp = n;
        while(temp>0){
            temp = temp/10;
            nod++;
        }
        
        k = k%nod;
        if(k<0){
            k = nod+k;
        }
        
        int div = (int)Math.pow(10, k);
        int q = n/div;
        int r = n%div;
        
        int multi = (int)Math.pow(10, nod-k);
        int ans = r*multi + q;
        System.out.println(ans);
    }
   }