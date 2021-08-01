import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }
    
    private int hashFunction(K key){
        int hs = key.hashCode();// [-inf, +inf]
        hs = Math.abs(hs);      // [0, +inf]
        hs = hs % buckets.length;// [0, N-1]
        return hs;
    }
    
    private int getKeyInBucket(int bi, K key){
        
        int i=0;
        for(HMNode node : buckets[bi]){
            if(key.equals(node.key)){// == problem  ,  equals no problem
                return i;
            }
            i++;
        }
        return -1;
    }

    public void put(K key, V value) throws Exception {
        int bi = hashFunction(key);
        int di = getKeyInBucket(bi, key);
        
        if(di == -1){
            // not exist -> add new HMNode
            HMNode node = new HMNode(key, value);
            buckets[bi].add(node);
            size++;
        }else{
            // exist -> update value
            HMNode node = buckets[bi].get(di);
            node.value = value;
        }
        
        // check for n/N >= k, k=2
        if(size > 2*buckets.length){
            rehasing();
        }
    }
    
    private void rehasing() throws Exception {
        LinkedList<HMNode>[] oldbuckets = buckets;
        initbuckets(oldbuckets.length*2);
        size = 0;
        
        for(int i=0;i<oldbuckets.length;i++){
            for(HMNode node: oldbuckets[i]){
                put(node.key, node.value);
            }
        }
    }

    public V get(K key) throws Exception {
        int bi = hashFunction(key);
        int di = getKeyInBucket(bi, key);
        
        if(di == -1){
            // not exist -> add new HMNode
            return null;
        }else{
            // exist -> update value
            HMNode node = buckets[bi].get(di);
            return node.value;
        }
    }

    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int di = getKeyInBucket(bi, key);
        
        if(di == -1){
            // not exist -> add new HMNode
            return false;
        }else{
            // exist -> update value
            return true;
        }
    }

    public V remove(K key) throws Exception {
        int bi = hashFunction(key);
        int di = getKeyInBucket(bi, key);
        
        if(di == -1){
            // not exist -> add new HMNode
            return null;
        }else{
            // exist -> update value
            HMNode node = buckets[bi].remove(di);
            size--;
            return node.value;
        }
    }

    public ArrayList<K> keyset() throws Exception {
        ArrayList<K> keys = new ArrayList<K>();
        
        for(int i=0;i<buckets.length;i++){
            for(HMNode node: buckets[i]){
                keys.add(node.key);
            }
        }
        
        return keys;
    }

    public int size() {
        return size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}