import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        
        int n = scn.nextInt();
        int star = 1;
        int space = n/2;
        
        int oval=1;
        for(int i=1;i<=n;i++){
            int ival=oval;
            
            for(int j=1;j<=space;j++){
                System.out.print("\t");
            }
            for(int j=1;j<=star;j++){
                System.out.print(ival+"\t");
                if(j<=star/2){
                    ival++;
                }else{
                    ival--;
                }
            }
            
            if(i<=n/2){
                space--;
                star += 2;
                oval++;
            }else{
                space++;
                star -= 2;
                oval--;
            }
            System.out.println();
        }

    }
}