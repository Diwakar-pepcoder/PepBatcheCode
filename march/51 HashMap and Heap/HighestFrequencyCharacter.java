import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(hm.containsKey(ch)){
                Integer val = hm.get(ch);
                val++;
                hm.put(ch, val);
                
            }else{
                hm.put(ch, 1);
            }
        }
        
        Character ans='.';
        Integer freq=0;
        for(Character key : hm.keySet()){
            Integer value = hm.get(key);
            if(value > freq){
                ans=key;
                freq = value;
            }
        }
        
        System.out.println(ans);
    }

}