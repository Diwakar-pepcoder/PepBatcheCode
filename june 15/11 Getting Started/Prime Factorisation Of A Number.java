import java.util.*;

public class Main{

public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        // int div=2;
        
        // while(div<=n){
        //     while(n%div==0){
        //         System.out.print(div+" ");
        //         n = n/div;
        //     }
        //     div++;
        // }
        
        for(int div=2;div<=n;div++){
            while(n%div==0){
                System.out.print(div+" ");
                n = n/div;
            }
        }
        
 }
}