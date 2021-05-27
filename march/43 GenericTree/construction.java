import java.util.*;
import java.io.*;

public class Main{
    public static class Node{
        int data;
        ArrayList<Node> childrens = new ArrayList<>();
    }
    
    public static class GenericTree{
        Node root;
        
        public void construct(int arr[]){
            Stack<Node> st = new Stack<>();
            
            for(int val: arr){
                if(val == -1){
                    st.pop();
                }else{
                    Node node = new Node();
                    node.data = val;
                    
                    if(st.size() == 0){
                        root = node;
                    }else{
                        st.peek().childrens.add(node);
                    }
                    
                    st.push(node);
                }
            }
        }
        
        public void displayHelper(Node node){
            System.out.print(node.data+" -> ");
            for(Node child: node.childrens){
                System.out.print(child.data+", ");
            }
            System.out.println(".");
            
            for(Node child: node.childrens){
                displayHelper(child);
            }
        }
        
        public void display(){
            displayHelper(root);
        }
        
    }
    
    public static void main(String ar[]){
        int arr[] = {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};
        
        GenericTree tree = new GenericTree();
        
        tree.construct(arr);
        tree.display();
    }
    
}