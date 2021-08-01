import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int ar[] = new int[n];
        
        for(int i=0;i<n;i++){
            ar[i] = scn.nextInt();
        }
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int val: ar){
            hm.put(val, 1);
        }
        
        int size=0;
        int start = 0;
        
        for(Integer key: hm.keySet()){
            if(hm.containsKey(key-1))continue;
            int s = 1;
            int f = key+1;
            while(hm.containsKey(f)){
                s++;
                f++;
            }
            if(s > size || (size == s && key < start)){
                start = key;
                size = s;
            }
        }
        
        for(int i=0;i<size;i++){
            System.out.println(start);
            start++;
        }
        
 }

}