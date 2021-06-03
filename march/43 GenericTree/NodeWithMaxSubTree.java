import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  
  static int maxData=0;
  static int maxSum=Integer.MIN_VALUE;
  
  public static class Pair{
      int maxNode;
      int maxSum = Integer.MIN_VALUE;
      int sum=0;
  }
  
  public static Pair maxsumtree(Node node){
      
        Pair mydata = new Pair();
        mydata.sum = node.data;
        
        for(Node child: node.children){
            Pair childPair = maxsumtree(child);
            mydata.sum += childPair.sum;
            
            if(childPair.maxSum > mydata.maxSum){
                mydata.maxSum = childPair.maxSum;
                mydata.maxNode = childPair.maxNode;
            }
        }
        
        if(mydata.sum > mydata.maxSum){
            mydata.maxSum = mydata.sum;
            mydata.maxNode = node.data;
        }
        
        return mydata;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    Pair p = maxsumtree(root);
    System.out.println(p.maxNode+"@"+p.maxSum);
    
  }

}