import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
        
    int n = scn.nextInt();
    int mid = n/2 + 1;
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(i==mid || j==mid){
                System.out.print("*\t");
            }else if(i==1 && j<mid){
                System.out.print("*\t");
            }else if(j==n && i<mid){
                System.out.print("*\t");
            }else if(j==1 && i>mid){
                System.out.print("*\t");
            }else if(i==n && j>mid){
                System.out.print("*\t");
            }else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }

    // for(int i=1;i<=n;i++){
    //     for(int j=1;j<=n;j++){
    //         if((i==mid || j==mid) || (i==1 && j<mid) || (j==n && i<mid) || (j==1 && i>mid) || (i==n && j>mid)) {
    //             System.out.print("*\t");
    //         }else{
    //             System.out.print("\t");
    //         }
    //     }
    //     System.out.println();
    // }
        
 }
}