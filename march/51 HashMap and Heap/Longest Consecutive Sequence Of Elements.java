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
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int val : a1){
            hm.put(val, 0);
        }
        
        int start = 0;
        int size=0;
        for(int key : hm.keySet()){
            if(false == hm.containsKey(key-1)){
                int val = key+1;
                int s = 1;
                while(hm.containsKey(val)){
                    val++;
                    s++;
                }
                
                if(s > size){
                    start = key;
                    size = s;
                }else if(s == size && key < start){
                    start = key;
                }
            }
        }
        for(int i=0;i<size;i++){
            System.out.println(start);
            start++;
        }
        
 }

}