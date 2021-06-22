import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    // write ur code here
    int n = scn.nextInt();

    int star = n;
    int space = 0;

    for (int i = 1; i <= n; i++) {

        for(int j=1;j<=space;j++){
            System.out.print("\t");
        }
        for(int j=1;j<=star;j++){
            if(i>=2&&i<=n/2){
                if(j==1 || j== star){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }else{
                System.out.print("*\t");
            }
        }
        System.out.println();
        
        if(i<=n/2){
            star -= 2;
            space++;
        }else{
            star += 2;
            space--;
        }
    }

  }
}