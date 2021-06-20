import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        int space = 1;
        int star = n/2+1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=star;j++){
                System.out.print("*\t");
            }
            for(int j=1;j<=space;j++){
                System.out.print("\t");
            }
            for(int j=1;j<=star;j++){
                System.out.print("*\t");
            }
            System.out.println();
            
            if(i<=n/2){
                star--;
                space += 2;
            }else{
                star++;
                space -= 2;
            }
        }

    }
}