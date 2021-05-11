import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = scn.nextInt();
        }
        
        HashMap<Integer, Boolean> hm = new HashMap<>();
        
        for(int e: a){
            hm.put(e, true);
        }
        
        int start = 0;
        int mlen = 0;
        
        Set<Integer> keys = hm.keySet();
        
        for(Integer key : keys){
            if(hm.containsKey(key-1) == false){
                int len=1;
                while(hm.containsKey(key+len)){
                    len++;
                }
                
                if((mlen == len && key < start) || len > mlen){
                    start = key;
                    mlen = len;
                }
            }
        }
        
        for(int i=0;i<mlen;i++){
            System.out.println(start + i);
        }
 }

}






