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
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int e: a1){
            if(hm.containsKey(e)){
                hm.put(e, hm.get(e)+1);
            }else{
                hm.put(e, 1);
            }
        }
        
        for(int e:a2){
            if(hm.containsKey(e)){
                if(hm.get(e)>0){
                    System.out.println(e);
                    hm.put(e, hm.get(e)-1);
                }
            }
        }
 }

}