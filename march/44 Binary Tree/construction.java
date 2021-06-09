import java.io.*;
import java.util.*;

public class Main {
        public static class Node{
            int data;
            Node left;
            Node right;
            Node(int data, Node left, Node right){
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }
        
        public static class Pair{
            Node node;
            int status;
            Pair(Node n, int s){
                node = n;
                status = s;
            }
        }
        
        public static class BinaryTree{
            Node root;
            
            public void construct(Integer arr[]){
                
                Stack<Pair> st = new Stack<>();
                root = new Node(arr[0], null, null);
                int idx=1;
                Pair p = new Pair(root, 0);
                st.push(p);
                
                while(st.size() > 0){
                    Node node;
                    if(arr[idx] == null){
                        node = null;
                    }else{
                        node = new Node(arr[idx], null, null);
                    }
                    idx++;
                    
                    Pair top = st.peek();
                    if(top.status == 0){
                        top.node.left = node;
                        top.status = 1;
                    }else{
                        top.node.right = node;
                        st.pop();
                    }
                    
                    if(node != null){
                        st.push(new Pair(node, 0));
                    }
                }
            }
            
        }
        
        public static void main(String[]args){
            BinaryTree bt = new BinaryTree();
            
            Integer arr[] = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
            bt.construct(arr);
            display(bt.root);
        }
        
        public static void display(Node node){
                String left="";
                if(node.left == null){
                    left = ".";
                }else{
                    left = ""+node.left.data;
                }
                
                String right="";
                if(node.right == null){
                    right = ".";
                }else{
                    right = ""+node.right.data;
                }
                
                System.out.println(left+" <- "+node.data+" -> "+ right);
                
                if(node.left != null)display(node.left);
                if(node.right != null)display(node.right);
        }
}