import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
            
            Scanner scn = new Scanner(System.in);
            String str =  scn.nextLine();
            
            HashMap<Character, Integer> hm = new HashMap<>();
            
            char maxO=' ';
            int freM = 0;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                
                if(hm.containsKey(ch)){// Integer fre = hm.get
                    int fre = hm.get(ch);
                    hm.put(ch, fre+1);
                }else{
                    hm.put(ch, 1);
                }
                
                if(hm.get(ch)>freM){
                    maxO = ch;
                    freM = hm.get(ch);
                }
            }
            System.out.println(maxO);
            // int maxFre=0;
            // char ch = ' ';
            // for(Character key: hm.keySet()){
            //     int fre = hm.get(key);
            //     if(fre > maxFre){
            //         ch = key;
            //         maxFre = fre;
            //     }
            // }
            // System.out.println(ch);
    }

}