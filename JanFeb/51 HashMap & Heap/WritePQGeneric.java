import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue<T> {
    ArrayList<T> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    public void upheapify(int i){
        if(i == 0)return;
        
        int pi = (i-1)/2;
        Comparable ith = (Comparable)data.get(i);
        Comparable pith = (Comparable)data.get(pi);
        
        if(ith.compareTo(pith) < 0 ){
            swap(i, pi);
            upheapify(pi);
        }
    }

    public void add(int val) {
        data.add(val);
        upheapify(data.size() - 1);
    }
    
    public void swap(int i, int j){
        T t = data.get(i);
        data.set(i, data.get(j));
        data.set(j, t);
    }

    public void downheapfiy(int i){
        int li = i*2+1;
        int ri = i*2+2;
        
        int min = i;
        
        
        
        if(li < data.size() && ((Comparable)data.get(li)).compareTo((Comparable)data.get(min)) < 0)min = li;
        if(ri < data.size() && ((Comparable)data.get(ri)).compareTo((Comparable)data.get(min)) < 0)min = ri;
        
        if(min != i){
            swap(i, min);
            downheapfiy(min);
        }
    }

    public T remove() {
        if(data.size() == 0){
            System.out.println("Underflow");
        }else{
            swap(0, data.size()-1);
            T val = data.remove( data.size()-1);
            downheapfiy(0);
            return val;
        }
    }

    public T peek() {
        if(data.size() == 0){
            System.out.println("Underflow");
        }else{
            return data.get(0);
        }
    }

    public int size() {
        return data.size();
    }
  }
  
  public static class Student implements Comparable<Student>{
      int roll;
      int score;
      String name;
      Student(int r, String n, int s){
          roll = r;
          name = n;
          score = s;
      }
      
      public int compareTo(Student b){
            return score - b.score;
      }
      
      public String toString(){
          return roll + " "+ name + " "+ score;
      }
  }

  public static void main(String[] args) throws Exception {
    PriorityQueue<Student> pq = new PriorityQueue<>();

    pq.add(new Student(3, "A", 678));
    pq.add(new Student(7, "B", 1278));
    pq.add(new Student(1, "C", 900));
    pq.add(new Student(4, "E", 987));
    pq.add(new Student(2, "D", 100));
    
    
    while(pq.size() > 0){
        System.out.println(pq.remove());
    }

  }
}