import java.io.*;
import java.util.*;

public class Main {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
        return size;
    }

    void display() {
        
        for(int i=0;i<size;i++){
            int ind = front+i;
            ind = ind % data.length;
            System.out.print(data[ind] + " ");
        }
        System.out.println();
    }

    void add(int val) {
        if(size == data.length){
            System.out.println("Queue overflow");
        }else{
            // rear
            int rear = front + size;
            if(rear >= data.length){
                rear -= data.length;
            }
            data[rear] = val;
            size++;
        }
    }

    int remove() {
        if(size == 0){
            System.out.println("Queue underflow");
            return -1;
        }else{
            int x = data[front];
            front++;
            size--;
            if(front == data.length)front = 0;
            return x;
        }
    }

    int peek() {
        if(size == 0){
            System.out.println("Queue underflow");
            return -1;
        }else{
            int x = data[front];
            return x;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("add")){
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if(str.startsWith("remove")){
        int val = qu.remove();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("peek")){
        int val = qu.peek();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(qu.size());
      } else if(str.startsWith("display")){
        qu.display();
      }
      str = br.readLine();
    }
  }
}