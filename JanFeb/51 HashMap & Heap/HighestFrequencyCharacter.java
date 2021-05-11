import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String s = scn.nextLine();
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            
            if(hm.containsKey(ch)){
                Integer fre = hm.get(ch);
                hm.put(ch, fre+1);
            }else{
                hm.put(ch, 1);
            }
        }
        
        Character maxch = ' ';
        Integer maxf = 0;
        Set<Character> keys = hm.keySet();
        
        for(Character key: keys){
            Integer freq = hm.get(key);
            if(freq > maxf){
                maxf = freq;
                maxch = key;
            }
        }
        
        System.out.println(maxch);
    }

}