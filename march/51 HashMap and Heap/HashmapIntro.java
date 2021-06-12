import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        hm.put("India", 100); // set
        System.out.println(hm);
        
        int value = hm.get("India");
        System.out.println(value);
        
        hm.put("USA", 40);
        hm.put("bangla", 20);
        hm.put("sri", 10);
        
        System.out.println(hm);
        
        hm.put("USA", 50);
        System.out.println(hm);
        
        // Set<String> keys = hm.keySet();
        for(String key : hm.keySet()){
            System.out.println(key+" -> "+hm.get(key));
        }
    }
    
}