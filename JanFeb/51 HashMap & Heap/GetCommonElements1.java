import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n1 = scn.nextInt();
        int a1[] = new int[n1];
        for(int i=0;i<n1;i++){
            a1[i] = scn.nextInt();
        }
        
        int n2 = scn.nextInt();
        int a2[] = new int[n2];
        for(int i=0;i<n2;i++){
            a2[i] = scn.nextInt();
        }
        
        HashMap<Integer, Boolean> hm = new HashMap<>();
        
        for(int e: a1){
            hm.put(e, true);
        }
        
        for(int e: a2){
            if(hm.containsKey(e)){
                if(hm.get(e)){
                    System.out.println(e);
                    hm.put(e, false);
                }
            }
        }
    }

}


        for(int e: a2){
            if(hm.containsKey(e)){
                System.out.println(e);
                hm.remove(e);
            }
        }
        