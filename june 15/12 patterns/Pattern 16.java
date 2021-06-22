import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     
    int n = scn.nextInt();
    
    int star = 1;
    int space = 2*n-3;
    
    for(int i=1;i<=n;i++){
        int ival=1;
        for(int j=1;j<=star;j++){
            System.out.print(ival+"\t");
            ival++;
        }
        for(int j=1;j<=space;j++){
            System.out.print("\t");
        }
        
        if(i==n){
            star--;
            ival--;
        }
        ival--;
        for(int j=1;j<=star;j++){
            System.out.print(ival+"\t");
            ival--;
        }
        star++;
        space -= 2;
        System.out.println();
    }

 }
}